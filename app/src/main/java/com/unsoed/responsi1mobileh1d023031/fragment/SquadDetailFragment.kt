package com.unsoed.responsi1mobileh1d023031.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.unsoed.responsi1mobileh1d023031.databinding.FragmentSquadDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SquadDetailFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentSquadDetailBinding? = null
    private val binding get() = _binding!!

    private var squadName: String? = null
    private var dateOfBirth: String? = null
    private var nationality: String? = null
    private var position: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            squadName = it.getString(ARG_SQUAD_NAME)
            dateOfBirth = it.getString(ARG_DATE_OF_BIRTH)
            nationality = it.getString(ARG_NATIONALITY)
            position = it.getString(ARG_POSITION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSquadDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textSquadName.text = squadName
        binding.textSquadDateOfBirth.text = "Date of Birth: $dateOfBirth"
        binding.textSquadNationality.text = "Nationality: $nationality"
        binding.textSquadPosition.text = "Position: $position"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_SQUAD_NAME = "squad_name"
        private const val ARG_DATE_OF_BIRTH = "date_of_birth"
        private const val ARG_NATIONALITY = "nationality"
        private const val ARG_POSITION = "position"

        fun newInstance(
            squadName: String,
            dateOfBirth: String,
            nationality: String,
            position: String
        ) = SquadDetailFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_SQUAD_NAME, squadName)
                putString(ARG_DATE_OF_BIRTH, dateOfBirth)
                putString(ARG_NATIONALITY, nationality)
                putString(ARG_POSITION, position)
            }
        }
    }
}