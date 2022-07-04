package com.rk.riggle_sales.utils.firebase

import android.app.*
import android.app.ActivityManager.RunningAppProcessInfo
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.gson.Gson
import com.rk.riggle_sales.R
import com.rk.riggle_sales.ui.welcome.WelcomeActivity
import org.json.JSONObject

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        Log.i("TAG", ":::$token")
        super.onNewToken(token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        if (remoteMessage.data.isNotEmpty()) {
            val jsonObject = JSONObject(remoteMessage.data as Map<*, *>)
            jsonObject.let {
                val gson = Gson()
                val notificationPojo =
                    gson.fromJson(jsonObject.toString(), NotificationPojo::class.java)
                //if (!isAppIsInBackground(applicationContext)) {
                /*EventBus.getDefault().post(notificationPojo)*/
                //} else {
                val resultIntent = Intent(applicationContext, WelcomeActivity::class.java)
                //val resultIntent = HomeActivity.newIntent(applicationContext)
                resultIntent.putExtra("notificationPojo", notificationPojo)
                sendNotification(notificationPojo, resultIntent)
                //}
            }
        }
    }

    private fun sendNotification(notificationPojo: NotificationPojo, intent: Intent?) {
        val pendingIntent = PendingIntent.getActivity(
            this,
            System.currentTimeMillis().toInt(), intent, 0 /*PendingIntent.FLAG_UPDATE_CURRENT*/
        )
        val channelId = getString(R.string.default_notification_channel_id)
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val notificationBuilder = getNotificationBuilder(notificationManager)
        NotificationCompat.Builder(this, channelId)
        notificationBuilder.setContentTitle(notificationPojo.title)
        notificationBuilder.setAutoCancel(true)
        notificationBuilder.setSound(defaultSoundUri)
        notificationBuilder.setContentText(notificationPojo.body)
        notificationBuilder.setBadgeIconType(NotificationCompat.BADGE_ICON_LARGE)
        notificationBuilder.setDefaults(Notification.DEFAULT_ALL)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            notificationBuilder.priority = NotificationManager.IMPORTANCE_HIGH
        } else {
            notificationBuilder.priority = Notification.PRIORITY_HIGH
        }
        notificationBuilder.setSmallIcon(R.mipmap.ic_circular_app_icon)
        //notificationBuilder.color = ContextCompat.getColor(applicationContext, R.color.colorPrimary)
        notificationBuilder.setContentIntent(pendingIntent)
        val notification = notificationBuilder.build()
        notification.flags = notification.flags or Notification.FLAG_AUTO_CANCEL
        notificationManager.notify(getSingleNotificationID("123"), notification)
    }

    private fun getNotificationBuilder(notificationManager: NotificationManager): NotificationCompat.Builder {
        val channelName = "MyShare"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("default", channelName, NotificationManager.IMPORTANCE_HIGH)
            channel.description = "Set notification priority"
            channel.setShowBadge(true)
            channel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            notificationManager.createNotificationChannel(channel)
        }
        return NotificationCompat.Builder(applicationContext, "default")
    }

    private fun getSingleNotificationID(user_id: String): Int {
        return (user_id + 5000).toInt()
    }

    private fun isAppIsInBackground(context: Context): Boolean {
        var isInBackground = true
        val am = context.getSystemService(ACTIVITY_SERVICE) as ActivityManager
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
            val runningProcesses = am.runningAppProcesses
            for (processInfo in runningProcesses) {
                if (processInfo.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    for (activeProcess in processInfo.pkgList) {
                        if (activeProcess == context.packageName) {
                            isInBackground = false
                        }
                    }
                }
            }
        } else {
            val taskInfo = am.getRunningTasks(1)
            /*val taskInfo1 = am.appTasks
            val compName = taskInfo1[0].taskInfo.baseActivity*/
            val componentInfo = taskInfo[0].topActivity
            if (componentInfo?.packageName == context.packageName) {
                isInBackground = false
            }
        }
        return isInBackground
    }

}
