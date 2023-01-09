package com.shahriar.a09_note_api_class_28__28_2.ui.login_user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shahriar.a09_note_api_class_28__28_2.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return if (this::binding.isInitialized) {
            binding.root
        } else {
            binding = FragmentLoginBinding.inflate(inflater, container, false)
            binding.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginUserBtn.setOnClickListener {

            loginUser()
        }
    }

    private fun loginUser() {
        var email = binding.userEmail.text.toString().trim()
        var password = binding.userPassword.text.toString().trim()
    }
}