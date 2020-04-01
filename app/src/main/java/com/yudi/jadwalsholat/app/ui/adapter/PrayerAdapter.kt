package com.yudi.jadwalsholat.app.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.yudi.jadwalsholat.R
import com.yudi.jadwalsholat.api.models.prayerschedule.PrayerItemData

/**
 * @author Yudi Rahmat
 */

class PrayerAdapter(layoutResId: Int, data: List<PrayerItemData?>?) :
    BaseQuickAdapter<PrayerItemData, BaseViewHolder>( layoutResId, data as MutableList<PrayerItemData>?) {

    override fun convert(helper: BaseViewHolder, item: PrayerItemData?) {
        val label: String? = item?.label
        val value: String? = item?.value

        helper.setText(R.id.tv_label, label)
        helper.setText(R.id.tv_value, value)
    }

}
