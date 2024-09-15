package com.chanu.sessacnavi

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.chanu.sessacnavi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavHost()
        setupActionBar()
        setupNavigationMenu()
    }

    // NavController 초기화
    private fun initNavHost() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment
        navController = navHostFragment.navController
    }

    // Navigation Drawer 설정
    private fun setupNavigationMenu() {
        binding.navView.setupWithNavController(navController)
    }

    // toolbar 액션바 설정
    private fun setupActionBar() {
        setSupportActionBar(binding.toolbar)
        appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    // toolbar 메뉴 설정
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        if (!binding.drawerLayout.isDrawerOpen(binding.navView)) {
            menuInflater.inflate(R.menu.overflow_menu, menu)
            return true
        }
        return super.onCreateOptionsMenu(menu)
    }

    // toolbar 메뉴 아이템 클릭 이벤트 처리
    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        item.onNavDestinationSelected(findNavController(R.id.fcv_main)) ||
            super.onOptionsItemSelected(item)

    // 뒤로가기 버튼 클릭 이벤트 처리
    override fun onSupportNavigateUp(): Boolean = navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
}
