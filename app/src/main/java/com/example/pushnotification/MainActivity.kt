package com.example.pushnotification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val NOTIFICATION_CHANNEL_ID: String = "4565"
    }
    lateinit var mShowFullQuoteIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val channelName: String = "NOTIFICATION_CHANNEL_NAME"
        val importance: Int = NotificationManager.IMPORTANCE_LOW
        val notificationChannel: NotificationChannel = NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, importance)
        notificationChannel.enableLights(true)
        notificationChannel.lightColor = Color.RED

        var notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)

        btnNotification.setOnClickListener{
            var title: String = etName.text.toString().trim()
            var subject: String = etSubject.text.toString().trim()
            var body: String = etBody.text.toString().trim()


            var notification: Notification = Notification.Builder(applicationContext, NOTIFICATION_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(body)
                .setChannelId(NOTIFICATION_CHANNEL_ID)
                .setContentTitle(subject).setSmallIcon(R.drawable.ic_notifications_none_black_24dp).build()

            notification.flags = Notification.FLAG_AUTO_CANCEL
            notificationManager.notify(1, notification)
        }
    }

}
