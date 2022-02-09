package com.app.clearscoreapp.donut_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.clearscoreapp.databinding.DonutDetailBinding
import com.app.remote.data.network_data.CreditResponse
import com.app.remote.Datanterface
import com.app.remote.NetworkRetrofitClass
import com.app.remote.repository.Repository

class DonutDetailActivity : AppCompatActivity() {
    private lateinit var binding: DonutDetailBinding
    private lateinit var viewModel: DonutViewModel
    private lateinit var donutRepository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DonutDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
         //initialise the service
        val apiService : Datanterface = NetworkRetrofitClass.getClient()
        donutRepository = Repository(apiService)

        viewModel = getViewModel()

        viewModel.donutDetails.observe(this, Observer {
            bindUI(it)
        })

    }
//UI for the Donut Detail info
    fun bindUI( it: CreditResponse?){

//Donut response from network
    binding.scoreBand.text = it?.creditReportInfo?.scoreBand.toString()
    binding.score.text = it?.creditReportInfo?.score .toString()
    binding.monthsSinceLastDefaulted.text = it?.creditReportInfo?.monthsSinceLastDefaulted.toString()
    binding.percentageCreditUsed.text = it?.creditReportInfo?.percentageCreditUsed.toString()
    binding.currentShortTermNonPromotionalDebt.text = it?.creditReportInfo?.currentShortTermNonPromotionalDebt.toString()
    binding.currentShortTermCreditLimit.text = it?.creditReportInfo?.currentShortTermCreditLimit.toString()
    binding.currentShortTermCreditUtilisation.text = it?.creditReportInfo?.currentShortTermCreditUtilisation.toString()
    binding.changeInShortTermDebt.text = it?.creditReportInfo?.changeInShortTermDebt.toString()
    binding.currentLongTermNonPromotionalDebt.text = it?.creditReportInfo?.currentLongTermNonPromotionalDebt.toString()
    binding.equifaxScoreBandDescription.text = it?.creditReportInfo?.equifaxScoreBandDescription.toString()
    binding.daysUntilNextReport.text = it?.creditReportInfo?.daysUntilNextReport.toString()
    binding.currentShortTermDebt.text = it?.creditReportInfo?.currentShortTermDebt.toString()
    binding.currentLongTermDebt.text = it?.creditReportInfo?.currentLongTermDebt.toString()

    }

    //View Model for the Donut
    private fun getViewModel(): DonutViewModel {
        return ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return DonutViewModel(donutRepository) as T
            }
        })[DonutViewModel::class.java]
    }
}

