package br.com.sbs.androidLibUtil.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

/**
 * Created by Valmir Júnior on 08/01/2019.
 */

object NotificationUtil {
    var CHANNEL_ID = "CHANNEL_ID"

    fun createNotificationChannel(context: Context, name: String, descriptionText: String,
                                          chanelId: String = CHANNEL_ID) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(chanelId, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager = context
                    .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun showNotification(context: Context, notificationId:Int, mBuilder: NotificationCompat.Builder){
        with(NotificationManagerCompat.from(context)) {
            notify(notificationId, mBuilder.build())
        }
    }

    fun notificationNormal(context: Context,idIcon:Int, title: String, content:String,
                           chanelId: String = CHANNEL_ID): NotificationCompat.Builder {
        return NotificationCompat.Builder(context, chanelId)
                .setSmallIcon(idIcon)
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
    }

    fun notificationLargeText(context: Context, idIcon:Int, title: String, content:String,
                              chanelId: String = CHANNEL_ID): NotificationCompat.Builder{
        return notificationNormal(context,idIcon,title,content,chanelId)
                .setStyle(NotificationCompat.BigTextStyle()
                        .bigText(content))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
    }

    fun notificationWithIntent(pendingIntent: PendingIntent,context: Context, idIcon:Int,
                               title: String, content:String,chanelId: String = CHANNEL_ID):
            NotificationCompat.Builder {

        return notificationNormal(context,idIcon,title,content,chanelId)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
    }

    fun notificationLargeTextWithIntent(pendingIntent: PendingIntent,context: Context, idIcon:Int,
                               title: String, content:String,chanelId: String = CHANNEL_ID):
            NotificationCompat.Builder {

        return notificationLargeText(context,idIcon,title,content,chanelId)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
    }

    fun getIntentToNotification(context: Context, intent: Intent): PendingIntent {
        // Create an explicit intent for an Activity in your app
        intent.apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        return PendingIntent.getActivity(context, 0, intent, 0)
    }
}