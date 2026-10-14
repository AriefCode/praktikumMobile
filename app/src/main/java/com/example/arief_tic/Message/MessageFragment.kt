package com.example.arief_tic.Message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.arief_tic.R
import com.example.arief_tic.databinding.FragmentHomeBinding
import com.example.arief_tic.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {
    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://api.dicebear.com/7.x/bottts/svg?seed=Alya"),
        MessageModel("Budi", "Sudah makan?", "https://api.dicebear.com/7.x/bottts/svg?seed=Budi"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://api.dicebear.com/7.x/bottts/svg?seed=Citra"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://api.dicebear.com/7.x/bottts/svg?seed=Dika"),
        MessageModel("Eka", "Nice job kemarin!", "https://api.dicebear.com/7.x/bottts/svg?seed=Eka"),
        MessageModel("Fajar", "Lagi ngapain?", "https://api.dicebear.com/7.x/bottts/svg?seed=Fajar"),
        MessageModel("Gita", "Boleh minta tolong?", "https://api.dicebear.com/7.x/bottts/svg?seed=Gita"),
        MessageModel("Hana", "Lihat email ya", "https://api.dicebear.com/7.x/bottts/svg?seed=Hana"),
        MessageModel("Irfan", "Oke noted", "https://api.dicebear.com/7.x/bottts/svg?seed=Irfan"),
        MessageModel("Joko", "Sampai jumpa besok", "https://api.dicebear.com/7.x/bottts/svg?seed=Joko")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Halaman message"

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter

    }
}