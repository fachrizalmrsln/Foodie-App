package com.id.zul.foodie.ui.listfoods

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ethanhua.skeleton.Skeleton
import com.ethanhua.skeleton.SkeletonScreen
import com.id.zul.foodie.R
import com.id.zul.foodie.model.Foods
import com.id.zul.foodie.ui.detail.DetailActivity
import com.id.zul.foodie.viewmodel.ViewModelFactory
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class ListFoodsActivity : AppCompatActivity() {

    private lateinit var viewModel: ListFoodsViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var shimmer: SkeletonScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_foods)
        initializeViews()
        getData()
    }

    private fun initializeViews() {
        viewModel = initializeViewModel()
        setRecyclerViews()
        setShimmer()
    }

    private fun initializeViewModel(): ListFoodsViewModel {
        val factory = ViewModelFactory.getInstance()
        return ViewModelProviders.of(this, factory).get(ListFoodsViewModel::class.java)
    }

    private fun setShimmer() {
        shimmer = Skeleton.bind(recyclerView)
            .adapter(adapter)
            .load(R.layout.layout_item_shimmer)
            .color(R.color.shimmerColor)
            .angle(0)
            .show()
    }

    private fun getData() {
        viewModel.getData().observe(
            this,
            Observer {
                if (it == null)
                    toast("Fail getting data from server")
                else {
                    setData(it)
                    shimmer.hide()
                }
            }
        )
    }

    private fun setRecyclerViews() {
        recyclerView = find(R.id.rv_list_foods)
        adapter = FoodAdapter(this) {
            startActivity<DetailActivity>(
                "image" to it.image,
                "desc" to it.desc,
                "name" to it.name
            )
        }

        if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            recyclerView.layoutManager = LinearLayoutManager(this)
        else
            recyclerView.layoutManager = GridLayoutManager(this, 3)

        recyclerView.adapter = adapter
    }

    private fun setData(data: List<Foods>) {
        val listData: MutableList<Foods> = mutableListOf()
        listData.clear()
        listData.addAll(data)
        adapter.setData(data)
    }

}
