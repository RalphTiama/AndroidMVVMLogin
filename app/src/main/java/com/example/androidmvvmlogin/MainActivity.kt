package com.example.androidmvvmlogin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.example.androidmvvmlogin.databinding.ActivityMainBinding
import com.example.androidmvvmlogin.ui.carousel.HorizontalMarginItemDecoration
import com.example.androidmvvmlogin.ui.carousel.ModelAdapter
import com.example.androidmvvmlogin.ui.carousel.ModelCarousel
import com.example.androidmvvmlogin.ui.login.LoginActivity
import com.example.androidmvvmlogin.ui.login.LoginState
import com.example.androidmvvmlogin.ui.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: ModelAdapter

    private var modelList = arrayListOf<ModelCarousel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lifecycleScope.launch {
            loginViewModel.state.collect{state ->
                when(state) {

                    LoginState.LogoutResult -> {
                        finish()
                        Intent(this@MainActivity, LoginActivity::class.java).also{
                            startActivity(it)
                        }
                    }

                    else -> {

                    }
                }

            }
        }

        binding.txtLogout.setOnClickListener {
            loginViewModel.logout()
        }


        loadData()


    }


    private fun loadData() {
        modelList.add(ModelCarousel("Fantastic Beast: The \n" + "Secrets of Dumble","Fantasy & Fiction","$12.44"))
        modelList.add(ModelCarousel("Fantastic Beast: The \n" + "Secrets of Dumble","Fantasy & Fiction","$2.44"))
        modelList.add(ModelCarousel("Fantastic Beast: The \n" + "Secrets of Dumble","Fantasy & Fiction","$3.44"))
        modelList.add(ModelCarousel("Fantastic Beast: The \n" + "Secrets of Dumble","Fantasy & Fiction","$12.44"))
        modelList.add(ModelCarousel("Fantastic Beast: The \n" + "Secrets of Dumble","Fantasy & Fiction","$12.44"))

        setupCarousel()

        adapter = ModelAdapter(this,modelList)
        binding.viewPager.adapter = adapter
        binding.viewPager.currentItem = 1

    }




    private fun setupCarousel(){

        val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
        val currentItemHorizontalMarginPx = resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
        val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            page.translationX = -pageTranslationX * position
            page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
            page.alpha = 0.25f + (1 - kotlin.math.abs(position))
        }
        binding.viewPager.setPageTransformer(pageTransformer)

        val itemDecoration = HorizontalMarginItemDecoration(
            this,
            R.dimen.viewpager_current_item_horizontal_margin
        )
        binding.viewPager.addItemDecoration(itemDecoration)


    }

}