package com.aait.universityui.university

import android.content.Intent
import android.net.Uri
import androidx.core.view.isGone
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.aait.coreui.base.BaseFragment
import com.aait.coreui.util.toGone
import com.aait.splashui.R
import com.aait.splashui.databinding.FragmentUniversityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UniversityFragment :
    BaseFragment<FragmentUniversityBinding>(FragmentUniversityBinding::inflate) {

    private val args by navArgs<UniversityFragmentArgs>()

    override fun onViewCreated() {
        setStatusBarColor(R.color.colorBg)

        binding.lyToolBar.tvTitle.text = getString(R.string.university_details)

        binding.tvName.text = args.university.name
        binding.tvState.isGone = args.university.state.isNullOrEmpty()
        binding.tvState.text = args.university.state
        binding.tvCountry.text = args.university.country
        binding.tvCountryCode.text = args.university.alphaTwoCode
        if (args.university.webPages.isEmpty()) {
            binding.tvWebPage.toGone()
        } else binding.tvWebPage.text = args.university.webPages[0]
    }

    override fun handleClicks() {
        binding.tvWebPage.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(args.university.webPages[0])))
        }
        binding.lyToolBar.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}