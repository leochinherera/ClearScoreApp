package com.app.clearscoreapp.donut_activity



import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.clearscoreapp.databinding.ActivityMainBinding
import com.app.clearscoreapp.donut_detail.DonutDetailActivity
import com.app.clearscoreapp.donut_detail.DonutViewModel
import com.app.remote.Datanterface
import com.app.remote.NetworkRetrofitClass
import com.app.remote.data.network_data.CreditResponse
import com.app.remote.repository.Repository
import java.math.RoundingMode
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: DonutViewModel
    private lateinit var donutRepository: Repository
    private var scheduleTaskExecutor: ScheduledExecutorService? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


//initialise data from the network
        val apiService : Datanterface = NetworkRetrofitClass.getClient()
        donutRepository = Repository(apiService)

        viewModel = getViewModel()
        scheduleTaskExecutor = Executors.newScheduledThreadPool(5)

        //Schedule a task to run every  5 second to update UI on a separate thread

        scheduleTaskExecutor?.scheduleAtFixedRate({
            // Execute the UI
            runOnUiThread { // Do stuff to update UI here!
                viewModel.donutDetails.observe(this) {
                    bindUI(it)
                }
            }
        }, 0, 10, TimeUnit.SECONDS) //time out of ui update seconds

    }

//UI for the Donut
private fun bindUI(it: CreditResponse?){
        //get the score from the Response
    val creditScore =it?.creditReportInfo?.score.toString()
    //Initialize ProgressBar
    val pieChart: ProgressBar = binding.statsProgressbar

    //calculate the score Percentage to display on ProgressBar
    fun calculateScorePercentage(): Int {
        val totalScore=700
        val scoreValue = Integer.parseInt(creditScore)
        val scoreStats = scoreValue.toBigDecimal().divide(totalScore.toBigDecimal(), 4, RoundingMode.HALF_UP)
        //return the percentage value
        return (scoreStats * 100.toBigDecimal()).toInt()
    }

    //update progress bar with score percentage value
    pieChart.progress= calculateScorePercentage()
    //the UI score value
    binding.creditScore.text = creditScore
   //Click the Donut to get more detail
    binding.backgroundProgressbar.setOnClickListener {

              val intent = Intent(this, DonutDetailActivity::class.java)

                    startActivity(intent)
        }

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
