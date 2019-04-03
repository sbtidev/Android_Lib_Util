package br.com.sbs.androidLibUtil.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * Created by Valmir Júnior on 22/11/2017.
 * Class to represent an Action Button Dialog
 */
class SectionFragmentAdapter(fm: FragmentManager, private var titles: List<String>,
                             private var fragments: List<Fragment>?): FragmentStatePagerAdapter(fm){

    /**
     * @param position to get title
     * @return String the title of the page in position
     */
    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

    /**
     * @param position of the Fragment, of Fragments passed in array on constructor
     * @return Fragment
     */
    override fun getItem(position: Int): Fragment {
        return fragments!![position]
    }


    override fun getCount(): Int {
        return if (fragments == null) 0 else fragments!!.size
    }
}
