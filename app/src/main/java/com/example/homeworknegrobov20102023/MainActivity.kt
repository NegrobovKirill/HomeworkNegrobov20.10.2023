package com.example.homeworknegrobov20102023

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.homeworknegrobov20102023.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var mediaPlayer: MediaPlayer
    private var pause: Boolean = false

    private var position = 0

    val playList = listOf(R.raw.the_day_that_never_comes, R.raw.now_that_we_are_dead, R.raw.my_friend_of_misery)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageButtonPlay.isSelected = true
        binding.imageButtonPause.isSelected = false
        binding.imageButtonNext.isSelected = true
        binding.imageButtonPrevious.isSelected = true

        binding.imageButtonPlay.isClickable = true
        binding.imageButtonPause.isClickable = false
        binding.imageButtonNext.isClickable = true
        binding.imageButtonPrevious.isClickable = true

        binding.imageButtonPlay.setOnClickListener {
            if (pause){
                mediaPlayer.seekTo(mediaPlayer.currentPosition)
                mediaPlayer.start()
                pause = false
            }
            else
            {
                playSongByPosition(position)
            }
            isPlaying(true)
        }
        binding.imageButtonPause.setOnClickListener {
            if (pause == false){
                mediaPlayer.pause()
                isPlaying(false)
                pause = true
            }

        }

        binding.imageButtonNext.setOnClickListener {

            mediaPlayer.stop()
            isPlaying(true)
            if (position < playList.size-1){
                ++position
            }else{
                position = 0
            }
            playSongByPosition(position)
            pause = false

        }
        binding.imageButtonPrevious.setOnClickListener {

            mediaPlayer.stop()
            isPlaying(true)
            if (position > 0){
                --position
            }else{
                position = playList.size-1
            }
            playSongByPosition(position)
            pause = false
        }

    }

    private fun playSongByPosition(position: Int){
        mediaPlayer = MediaPlayer.create(applicationContext,playList[position])
        mediaPlayer.start()
        binding.textView.text = resources.getResourceName(playList[position]).removePrefix("com.example.homeworknegrobov20102023:raw/").replace("_"," ")
    }

    fun isPlaying(flag: Boolean){
        binding.imageButtonPlay.isSelected = !flag
        binding.imageButtonPlay.isClickable = !flag
        binding.imageButtonPause.isSelected = flag
        binding.imageButtonPause.isClickable = flag
    }

}