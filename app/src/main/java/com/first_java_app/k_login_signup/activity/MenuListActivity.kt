package com.first_java_app.k_login_signup.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.first_java_app.k_login_signup.R
import com.first_java_app.k_login_signup.RestaurantStore
import com.first_java_app.k_login_signup.adapter.RestaurantAdapter
import com.first_java_app.k_login_signup.databinding.ActivityMenuListBinding
import com.first_java_app.k_login_signup.model.Restaurant
import com.first_java_app.k_login_signup.viewmodel.MenuListViewModel

class MenuListActivity : AppCompatActivity(),RestaurantAdapter.OnItemClickListener {
    private lateinit var binding: ActivityMenuListBinding
    private lateinit var viewModel: MenuListViewModel
    lateinit var adapter: RestaurantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu_list)
        viewModel = ViewModelProvider(this).get(MenuListViewModel::class.java)

        ActionToolBar()
        setUpIdolListView()
        registerData()

    }

    private fun ActionToolBar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setTitle("List Menu")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadData()
    }

    private fun registerData() {
        viewModel.listOfData.observe(this) {
            adapter.submitList(it)
        }
    }

    private fun setUpIdolListView() {
        adapter = RestaurantAdapter(this@MenuListActivity)
        binding.rvMenuList.layoutManager = LinearLayoutManager(this)
        binding.rvMenuList.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_listview -> {
                binding.rvMenuList.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_gridview -> {
                binding.rvMenuList.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onItemClick(position: Int) {
        val builder = AlertDialog.Builder(this)
        builder.apply {
            val ten =adapter.mListener.binding.rvMenuList.get(position).findViewById<TextView>(R.id.txt_ten).text.toString()
            setTitle("Delete")
            setMessage("Do you want ${ten} to delete?")
            setPositiveButton("YES"){dialog, _ ->
                val restaurant : ArrayList<Restaurant>  = RestaurantStore.getDataset()
                restaurant.removeAt(position)
                adapter.submitList(restaurant)
                adapter.notifyItemRemoved(position)
                dialog.dismiss()
            }
            setNegativeButton("NO"){dialog, _ ->
                dialog.dismiss()
            }
        }
        builder.show()
    }
}