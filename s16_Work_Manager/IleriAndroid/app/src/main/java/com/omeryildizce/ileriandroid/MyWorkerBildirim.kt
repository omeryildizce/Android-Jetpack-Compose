package com.omeryildizce.ileriandroid

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorkerBildirim(appContext: Context, workerParams:WorkerParameters) : Worker(appContext, workerParams) {
    override fun doWork(): Result {
        bildirimOlustur(applicationContext)

        return Result.success()
    }

    fun bildirimOlustur(context: Context){
        val  builder: NotificationCompat.Builder
        val bildirimYoneticisi = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val kanalId = "kanalId"
        val kanalAd = "kanalAd"
        val kanalTanitim = "kanalTanitim"
        val kanaOnceligi = NotificationManager.IMPORTANCE_HIGH
        var kanal:  NotificationChannel? = bildirimYoneticisi.getNotificationChannel(kanalId)

        if (kanal == null)
        {
            kanal = NotificationChannel(kanalId,kanalAd, kanaOnceligi)
            kanal.description = kanalTanitim
            bildirimYoneticisi.createNotificationChannel(kanal)
        }
        builder = NotificationCompat.Builder(context,kanalId)
        builder.setContentTitle("Başlık")
            .setContentText("İçerik")
            .setSmallIcon(R.drawable.resim)
            .setAutoCancel(true)
        bildirimYoneticisi.notify(1, builder.build())
    }
}