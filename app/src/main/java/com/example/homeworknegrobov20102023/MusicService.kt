package com.example.homeworknegrobov20102023

import android.app.Service
import android.content.Intent
import android.os.IBinder


class MusicService: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action){
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stop()
            Actions.NEXT.toString() -> next()
            Actions.PREVIOUS.toString() -> previous()
        }
        return super.onStartCommand(intent, flags, startId)
    }


    private fun start(){
        
    }

    private fun stop(){

    }

    private fun next(){

    }

    private fun previous(){

    }


}