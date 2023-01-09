package com.shahriar.a09_note_api_class_28__28_2.ui.register_user

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.shahriar.a09_note_api_class_28__28_2.R
import com.shahriar.a09_note_api_class_28__28_2.data.model.registration.RequestUserRegistration
import com.shahriar.a09_note_api_class_28__28_2.databinding.FragmentRegistrationBinding
import com.shahriar.a09_note_api_class_28__28_2.utils.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    lateinit var binding: FragmentRegistrationBinding

    val viewModel by viewModels<RegistrationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return if (this::binding.isInitialized) {
            binding.root
        } else {
            binding = FragmentRegistrationBinding.inflate(inflater, container, false)
            binding.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerUserBtn.setOnClickListener {

            registerUser()
        }
        viewModel.userRegistrationResponse.observe(viewLifecycleOwner){

            when(it){
                is UiState.Error -> {
                    Log.i("TAG", "Error: ${it.message}")
                }
                is UiState.Loading -> {
                    Log.i("TAG", "Loading......")
                }
                is UiState.Success -> {
                    Log.i("TAG", "Success: ${it.data}")

                    findNavController().navigate(R.id.action_registrationFragment_to_homeFragment)
                }
            }
        }
    }

    private fun registerUser() {
        val name = binding.userName.text.toString().trim()
        val email = binding.userEmail.text.toString().trim()
        val password = binding.userPassword.text.toString().trim()

        val userRegReq= RequestUserRegistration(email, password, name)

        viewModel.registerUser(userRegReq)
    }
}