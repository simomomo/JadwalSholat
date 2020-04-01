package com.yudi.jadwalsholat.app.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.yudi.jadwalsholat.R
import com.yudi.jadwalsholat.api.models.prayerschedule.PrayerItemData
import com.yudi.jadwalsholat.api.models.prayerschedule.Timings
import com.yudi.jadwalsholat.app.base.BaseFragment
import com.yudi.jadwalsholat.app.ui.adapter.PrayerAdapter
import com.yudi.jadwalsholat.app.ui.viewmodel.PrayerViewModel
import com.yudi.jadwalsholat.databinding.PrayerFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.collections.ArrayList

/**
 * @author Yudi Rahmat
 */


class PrayerFragment : BaseFragment() {
    private val prayerViewModel: PrayerViewModel by viewModel()
    private lateinit var binding: PrayerFragmentBinding
    private lateinit var prayerAdapter: PrayerAdapter
    private lateinit var mContext: Context

    private var listData: ArrayList<PrayerItemData?> = ArrayList()

    private var city: String?       = "Bandung"
    private var country : String?   = "Indonesia"
    private var method: Int         = 8

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        binding = DataBindingUtil.inflate<PrayerFragmentBinding>( inflater, R.layout.prayer_fragment, container, false).apply {}

        (activity as? AppCompatActivity)?.supportActionBar?.hide()
        setupPrayerAdapter(inflater, container)

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    private fun doPrayerCallback() {
        binding.pbLoading.visibility = View.VISIBLE

        prayerViewModel.loadData(city!!, country!!, method)
        prayerViewModel.getPrayerData().observe(this, Observer {
            binding.pbLoading.visibility = View.GONE
            it.let {
                var data: Timings? = it?.timings

                listData.clear()
                listData.add(PrayerItemData("Imsak",    data?.imsak))
                listData.add(PrayerItemData("Fajr",     data?.fajr))
                listData.add(PrayerItemData("Sunrise",  data?.sunrise))
                listData.add(PrayerItemData("Dhuhr",    data?.dhuhr))
                listData.add(PrayerItemData("Asr",      data?.asr))
                listData.add(PrayerItemData("Maghrib",  data?.maghrib))
                listData.add(PrayerItemData("Isha",     data?.maghrib))

                binding.tvCity.text     = "$city, $country"
                binding.tvToday.text    = "Today/" + it?.date?.gregorian?.weekday?.en
                binding.tvDate.text     = it?.date?.readable

                prayerAdapter.notifyDataSetChanged()
            }
        })
    }

    private fun setupPrayerAdapter(inflater: LayoutInflater, container: ViewGroup?) {
        prayerAdapter   = PrayerAdapter(R.layout.view_row_prayer, listData)
        val view: View  = inflater.inflate(R.layout.view_nodata, container, false)

        binding.rvList.layoutManager = LinearLayoutManager(mContext)
        binding.rvList.adapter = prayerAdapter
        prayerAdapter.emptyView = view
        prayerAdapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        
        doPrayerCallback()
    }
}
