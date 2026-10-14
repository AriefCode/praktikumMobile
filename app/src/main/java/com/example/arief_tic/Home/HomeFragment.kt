package com.example.arief_tic.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.arief_tic.Home.Pertemuan5.LimaActivity
import com.example.arief_tic.Home.Pertemuan6.EnamActivity
import com.example.arief_tic.LoginActivity
import com.example.arief_tic.R
import com.example.arief_tic.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tampungNama = requireActivity().intent.getStringExtra("nama")
        val tampungUmur = requireActivity().intent.getIntExtra("umur", 0)

        Log.w("hasil", "nama: $tampungNama umur: $tampungUmur")

        binding.namaTeman.text = tampungNama

        binding.btnKembali.setOnClickListener {
//            val intent = Intent(this@MainActivity, LoginActivity::class.java)
//            startActivity(intent)
            requireActivity().finish()
        }

        binding.btnSnackBar.setOnClickListener {
            Snackbar.make(binding.root, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Tutup"){
                    Log.e("Info Snackbar","Snackbar ditutup")
                }
                .show()
        }

        binding.btnAlertDialog.setOnClickListener{
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Ya!")
                }
                .setNeutralButton("apani"){
                        dialog, _ ->
                    dialog.dismiss()
                    binding.namaTeman.text = "Berubah dia hahaa"
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog","Anda memilih Tidak!")
                }
                .show()
        }

        binding.btnToLima.setOnClickListener {
            val intent = Intent(requireContext(), LimaActivity::class.java)
            startActivity(intent)
        }

        binding.btnToEnam.setOnClickListener {
            val intent = Intent(requireContext(), EnamActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogout.setOnClickListener {
            val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)

            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    startActivity(Intent(requireContext(), LoginActivity::class.java))
                    requireActivity().finish()

                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }

}