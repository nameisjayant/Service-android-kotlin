package com.yt.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

const val SERVICE_COMMAND = "Command"
const val NOTIFICATION_TEXT = "NotificationText"


class TimerService() : Service(),CoroutineScope {

    override val coroutineContext: CoroutineContext = TODO()

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)

    }

    override fun onDestroy() {
        super.onDestroy()

    }
}