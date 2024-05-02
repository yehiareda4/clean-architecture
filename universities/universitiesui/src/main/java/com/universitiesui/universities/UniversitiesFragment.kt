package com.universitiesui.universities

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.aait.coreui.base.BaseFragment
import com.aait.coreui.base.util.applyCommonSideEffects
import com.aait.coreui.util.toGone
import com.aait.coreui.util.toJson
import com.aait.homeui.R
import com.aait.homeui.databinding.FragmentUniversitiesBinding
import com.coredomain.util.DataState
import com.universitiesdomain.model.Universities
import com.universitiesdomain.model.University
import com.universitiesui.universities.adapter.UniversitiesAdapter
import com.yehia.reda.mira_recycle_view_tools.util.CallBack
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UniversitiesFragment :
    BaseFragment<FragmentUniversitiesBinding>(FragmentUniversitiesBinding::inflate) {

    private val viewModel by viewModels<UniversitiesViewModel>()

    private var list: MutableList<University> = ArrayList()
    private val universitiesAdapter by lazy {
        UniversitiesAdapter {
            findNavController().navigate(
                UniversitiesFragmentDirections.navToUniversityFragment(
                    it
                )
            )
        }
    }

    override fun onViewCreated() {
        setStatusBarColor(R.color.colorBg)
        binding.lyToolBar.ivBack.toGone()
        binding.lyToolBar.tvTitle.text = getString(R.string.universities)
        setUpRecycle()
    }

    private fun setUpRecycle() {
        binding.mRvList.setUp(object : CallBack {
            override fun onRefresh() {
                getUniversities()
            }

            override fun onReset() {
                list = ArrayList()
                universitiesAdapter.submitList(ArrayList())
                binding.mRvList.setAdapter(universitiesAdapter)
            }

            override fun onInit() {
                binding.mRvList.setAdapter(universitiesAdapter)
            }
        })

        getUniversities()
        if (list.isEmpty()) {
            viewModel.getOfflineUniversities()
        }
    }

    private fun getUniversities() {
        // RESET THE LIST
        binding.mRvList.stopLoading(0)
        binding.mRvList.callBack.onReset()
        binding.mRvList.toggleShimmerLoading(View.VISIBLE)

        lifecycleScope.launch {
            delay(500)
            viewModel.getUniversities()
        }
    }

    override fun startObserver() {
        super.startObserver()

        observer()
        offline()
    }

    private fun observer() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.universitiesResponse.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collectLatest {
                    when (it) {
                        is DataState.Error -> {
                            when (it.throwable) {
                                else -> {
                                    it.applyCommonSideEffects(this@UniversitiesFragment)
                                }
                            }
                        }

                        else -> {
                            it.applyCommonSideEffects(this@UniversitiesFragment) { data ->
                                setUniversities(data)
                            }
                        }
                    }
                }
        }
    }

    private fun offline() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.universitiesOfflineResponse.flowWithLifecycle(
                lifecycle, Lifecycle.State.STARTED
            ).collectLatest {
                if (it.isNotEmpty()) {
                    setUniversities(it)
                }
            }
        }
    }


    private fun setUniversities(data: MutableList<University>) {
        binding.mRvList.stopLoading(0)
        list.clear()
        list.addAll(data)
        universitiesAdapter.submitList(list)
        if (list.isEmpty()) {
            noData()
        } else {
            viewModel.setUniversities(Universities(list).toJson())
        }
    }

    private fun noData() {
        binding.mRvList.stopLoading()
        binding.mRvList.toggleShowError(
            View.VISIBLE
        )
    }

    override fun onLoad(showLoading: Boolean) {

    }

    override fun onFailAll() {
        noData()
    }
}