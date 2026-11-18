package com.example.arief_tic.Note

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.arief_tic.databinding.ActivityNoteFormBinding
import com.example.arief_tic.data.AppDatabase
import com.example.arief_tic.data.entity.NoteEntity
import kotlinx.coroutines.launch

class NoteFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteFormBinding
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = AppDatabase.getInstance(this)
        binding.btnSaveNote.setOnClickListener {
            val title = binding.etTitle.text.toString().trim()
            val content = binding.etContent.text.toString().trim()
            if (title.isBlank() || content.isBlank()) {
                Toast.makeText(
                    this, "Isi semua kolom!", Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            binding.btnSaveNote.isEnabled = false
            lifecycleScope.launch {
                try {
                    db.noteDao().insert(
                        NoteEntity(title = title, content = content)
                    )
                    finish()
                } catch (e: Exception) {
                    binding.btnSaveNote.isEnabled = true
                    Toast.makeText(
                        this@NoteFormActivity,
                        "Gagal menyimpan catatan",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}