package com.example.fabicon

import android.graphics.Interpolator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.OvershootInterpolator
import com.google.android.material.floatingactionbutton.FloatingActionButton
import javax.security.auth.login.LoginException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        private const val TAG = "MainActivity"
    }

    lateinit var fabMain: FloatingActionButton
    lateinit var fabMovie: FloatingActionButton
    lateinit var fabMusic: FloatingActionButton
    lateinit var fabPhoto: FloatingActionButton
    var isMenuOpen = false
    val translationY = 100f
    val interpolator = OvershootInterpolator()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFabMunu()
    }

    private fun initFabMunu() {
         fabMain = findViewById(R.id.main)
        fabMovie = findViewById(R.id.movie)
        fabMusic = findViewById(R.id.music)
        fabPhoto = findViewById(R.id.photo)

        fabMovie.alpha = 0f
        fabMusic.alpha = 0f
        fabPhoto.alpha = 0f

        fabMovie.translationY = translationY
        fabMusic.translationY = translationY
        fabPhoto.translationY = translationY

        fabMain.setOnClickListener(this)
        fabMovie.setOnClickListener(this)
        fabMusic.setOnClickListener(this)
        fabPhoto.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
         when(view){
             fabMain ->{
                 Log.i(TAG, "onClick: fabMain clicked")
                 if(isMenuOpen) {
                     closeMenu()
                     isMenuOpen = false
                 }else{
                     openMenu()
                     isMenuOpen = true
                 }
             }
             fabMovie ->{
                 Log.i(TAG, "onClick: fabMovie clicked")
                 if(isMenuOpen) {
                     closeMenu()
                     isMenuOpen = false
                 }else{
                     openMenu()
                     isMenuOpen = true
                 }
             }
             fabMusic ->{
                     Log.i(TAG, "onClick: fabMusic clicked")
                     if(isMenuOpen) {
                         closeMenu()
                         isMenuOpen = false
                     }else{
                         openMenu()
                         isMenuOpen = true
                     }
                 }
             fabPhoto ->{
                     Log.i(TAG, "onClick: fabPhoto clicked")
                     if(isMenuOpen) {
                         closeMenu()
                         isMenuOpen = false
                     }else{
                         openMenu()
                         isMenuOpen = true
                     }
                 }
             else ->{
                 Log.i(TAG, "onClick: nothing find")
             }
         }
    }

    private fun openMenu() {
        fabMain.animate().rotation(45f).setInterpolator(interpolator).setDuration(300).start()
        fabMovie.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start()
        fabMusic.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start()
        fabPhoto.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start()
    }

    private fun closeMenu() {
        fabMain.animate().rotation(0f).setInterpolator(interpolator).setDuration(300).start()
        fabMovie.animate().translationY(1f).alpha(0f).setInterpolator(interpolator).setDuration(300).start()
        fabMusic.animate().translationY(1f).alpha(0f).setInterpolator(interpolator).setDuration(300).start()
        fabPhoto.animate().translationY(1f).alpha(0f).setInterpolator(interpolator).setDuration(300).start()
    }


}