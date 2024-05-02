package com.aait.coreui.base

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.viewbinding.ViewBinding
import com.aait.coreui.R
import com.aait.coreui.base.util.NetworkExtensionsActions
import com.aait.coreui.util.ProgressUtil
import com.aait.coreui.util.ToastType
import com.aait.coreui.util.hideKeyboard
import com.aait.coreui.util.showToast
import javax.inject.Inject

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(private val inflate: Inflate<VB>) : Fragment(),
    NetworkExtensionsActions {

    @Inject
    lateinit var progressUtil: ProgressUtil

    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startObserver()
        receiveData()
        handleClicks()
        onViewCreated()
    }

    open fun startObserver() {}

    abstract fun onViewCreated()

    open fun handleClicks() {}

    open fun receiveData() {}

    override fun onStart() {
        super.onStart()
        backDefaultKey()
    }
    private fun backDefaultKey() {
        requireView().isFocusableInTouchMode = true
        requireView().requestFocus()

        requireView().setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean {
                if (event.action == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        onBackPressed()
                        return true
                    }
                }
                return false
            }
        })
    }

    open fun onBackPressed() {
        requireActivity().onBackPressed()
    }

    override fun onLoad(showLoading: Boolean) {
        if (showLoading) progressUtil.showProgress()
        else progressUtil.hideProgress()
    }

    override fun onCommonError(exceptionMsgId: Int) {
        onLoad(false)
        requireActivity().showToast(getString(exceptionMsgId), ToastType.ERROR)
        onFailAll()
    }

    override fun onShowSuccessToast(msg: String?) {
        requireActivity().showToast(msg, ToastType.SUCCESS)
    }

    override fun onFail(msg: String?) {
        requireActivity().showToast(msg, ToastType.ERROR)
        onFailAll()
    }

    open fun onFailAll() {}

    override fun authorizationNeedActive(msg: String) {
        requireActivity().showToast(msg, ToastType.WARNING)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        requireView().hideKeyboard()
        _binding = null
    }

    open fun setStatusBarColor(colorId: Int) {
        val color = ContextCompat.getColor(requireContext(), colorId)
        requireActivity().window.statusBarColor = color
        requireActivity().window.navigationBarColor = color
    }
}