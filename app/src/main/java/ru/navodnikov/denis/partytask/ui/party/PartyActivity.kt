package ru.navodnikov.denis.partytask.ui.party

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.navodnikov.denis.domain.entity.PartyItem
import ru.navodnikov.denis.partytask.R
import ru.navodnikov.denis.partytask.databinding.ActivityPartyBinding


class PartyActivity : AppCompatActivity() {

    private val partyViewModel: PartyViewModel by viewModel()
    private lateinit var binding: ActivityPartyBinding
    private lateinit var visitorsRecyclerAdaptor: VisitorsRecyclerAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPartyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initScreen()
        configureLiveDataObservers()
    }

    private fun initScreen() {
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }
        binding.listOfVisitorsRv?.apply {
            layoutManager = LinearLayoutManager(context)
            visitorsRecyclerAdaptor = VisitorsRecyclerAdaptor()
            adapter = visitorsRecyclerAdaptor
        }
    }

    private fun configureLiveDataObservers() {
        partyViewModel.getPartyLiveData().observe(this, {
            bindPartyItem(it)
        })
        partyViewModel.getMassageLiveData().observe(this, {
            showMessage(it)
        })
    }

    private fun bindPartyItem(partyItem: PartyItem) {
        Picasso.get().load(partyItem.partyImage).into(binding.partyImageView)
        Picasso.get().load(partyItem.organizerImage).into(binding.organizerImageView)
        binding.nameOfOrganizerTextView.text = getString(R.string.invited, partyItem.nameOfOrganizer)
        binding.partyTextView.text = partyItem.partyName
        visitorsRecyclerAdaptor.setItems(partyItem.visitors)
    }

    private fun showMessage(error: Int) {
        val snackBar =
            Snackbar.make(
                binding.coordinator,
                getString(error),
                Snackbar.LENGTH_LONG
            )
        snackBar.show()
    }
}