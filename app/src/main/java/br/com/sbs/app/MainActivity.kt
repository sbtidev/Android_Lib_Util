package br.com.sbs.app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.sbs.androidLibUtil.util.NotificationUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NotificationUtil.CHANNEL_ID = BuildConfig.APPLICATION_ID
        NotificationUtil.createNotificationChannel(this,"name","descrição")
        val pendingIntent = NotificationUtil.getIntentToNotification(this,
                Intent(this,MainActivity::class.java)
        )
        val mBuilder = NotificationUtil.notificationLargeTextWithIntent(pendingIntent,this,
                R.drawable.ic_launcher_background,"teste",
                "sdghfsdçgjklçfksdlhfsdjçhksdjlçfkfçghjsdfçklghfjsdçhlsdghsagkfsçghljkdlghfsdlhgsdh")
        NotificationUtil.showNotification(this,1000, mBuilder)

    }
}
