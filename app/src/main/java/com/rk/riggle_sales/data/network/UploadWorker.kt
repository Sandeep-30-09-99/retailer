package com.rk.riggle_sales.data.network

class UploadWorker {}/*@WorkerInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val mainRepository: MainRepository
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        // get Input Data back using "inputData" variable
        val filePath = inputData.getString("file_path")
        val baseUrl = inputData.getString("base_url")
        return try {

            *//*val request = SendRequest<UploadRequest>()
            request.payload = UploadRequest("image/png", "png", "LOGO")
            val result = mainRepository.uploadImage(request)*//*

            val requestFile =
                ProgressRequestBody(File(filePath), object : ProgressRequestBody.UploadCallbacks {
                    override fun onProgressUpdate(s: Long, l: Long) {
                    }

                    override fun onError() {
                    }

                    override fun onFinish() {
                    }
                })
            var base_url = ""
            var path_url = ""
            val urlArray: Array<String> = baseUrl?.split("logo")?.toTypedArray()!!
            if (urlArray.size > 1) {
                base_url = urlArray[0]
                path_url = "logo" + urlArray[1]
            }
            val retrofit = Retrofit.Builder()
                .baseUrl(
                    base_url *//*"https://takein-content.s3.ap-southeast-1.amazonaws.com/logo/"*//*
                ).build()
            val imageInterface = retrofit.create(
                UpdateImageInterface::class.java
            )
            val call = imageInterface.updateImage(path_url, requestFile)
            val response = call.execute()
            if (response.code() == 200) {
                Result.success()
            } else {
                Result.retry()
            }
        } catch (e: Exception) {
            Result.retry()
        }
    }
}*/