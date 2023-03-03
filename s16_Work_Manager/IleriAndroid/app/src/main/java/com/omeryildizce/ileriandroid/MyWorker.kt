package com.omeryildizce.ileriandroid

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(appContext :Context, workerParameters: WorkerParameters ) : Worker(appContext, workerParameters) {
    override fun doWork(): Result {
        val toplam = 10+ 20
        Log.e("Arkaplan işlemi sonucu", "Toplam: $toplam")
        return Result.success()
    }
}