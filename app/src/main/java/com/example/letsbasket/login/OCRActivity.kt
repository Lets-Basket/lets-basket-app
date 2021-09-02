package com.example.letsbasket.login

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.text.Editable
import android.util.Log
import com.example.letsbasket.R
import com.example.letsbasket.categoryTab.CategoryActivity
//import com.google.api.services.vision.v1.model.*
//import com.google.cloud.vision.v1.ImageAnnotatorClient
//import com.google.cloud.vision.v1.Feature
//import com.google.cloud.vision.v1.Feature.Type
//import com.google.cloud.vision.v1.Image
//import com.google.cloud.vision.v1.AnnotateImageRequest
//import com.google.protobuf.ByteString
import kotlinx.android.synthetic.main.activity_button.*
import kotlinx.android.synthetic.main.activity_ocr.*
import kotlinx.android.synthetic.main.activity_ocr.btnImgUpload
import kotlinx.android.synthetic.main.activity_register.*
//import kotlinx.coroutines.delay
import java.io.ByteArrayOutputStream
//import okio.ByteString
import java.io.File
import java.io.OutputStream
import java.net.URI

class OcrActivity : AppCompatActivity() {
    //private val CLOUD_VISION_API_KEY: String = "AIzaSyCcEoabv8zaWT9SYI4138HAbFOQu_DeVRo"
    val imgFileName = "../res/drawable/mobile_cropped.jpeg"
    private val OPEN_GALLERY = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ocr)

        btnImgUpload.setOnClickListener{
            openGallery()
        }

        //quickstart(imgFileName)
    }

    /*
    fun quickstart(imageFile: ByteArray) {
        // [START vision_quickstart]
        // import com.google.cloud.vision.v1.ImageAnnotatorClient
        // import java.io.File
        //val imgProto = ByteString.copyFrom(File(imageFileName).readBytes())
        val imgProto = ByteString.copyFrom(imageFile)
        val vision = ImageAnnotatorClient.create()

        // Set up the Cloud Vision API request.
        val img = Image.newBuilder().setContent(imgProto).build()
        val feat = Feature.newBuilder().setType(Type.TEXT_DETECTION).build()
        val request = AnnotateImageRequest.newBuilder()
            .addFeatures(feat)
            .setImage(img)
            .build()

        // Call the Cloud Vision API and perform label detection on the image.
        val result = vision.batchAnnotateImages(arrayListOf(request))

        // 로고 detection도 해보자..!
        val feat_logo = Feature.newBuilder().setType(Type.LOGO_DETECTION).build()
        val request_logo = AnnotateImageRequest.newBuilder()
            .addFeatures(feat_logo)
            .setImage(img)
            .build()
        val label_result = vision.batchAnnotateImages(arrayListOf(request_logo))

        val OCR_result = result.responsesList[0].textAnnotationsList[0].description
        val userInfoList = OCR_result.split("\n")
        Log.d("로고 인식 결과: ", label_result.responsesList[0].logoAnnotationsList[0].description)
        Log.d("OCR 결과: ", userInfoList.toString())
        //getMsg()


        // Print the label annotations for the first response.
        //result.responsesList[0].labelAnnotationsList.forEach { label ->
        //    println("${label.description} (${(label.score * 100).toInt()}%)")
        //}
        // [END vision_quickstart]
    }
    */


    private fun openGallery(){
        val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
        //val intent: Intent = Intent(Intent.ACTION_PICK)
        intent.setType("image/*")
        //intent.setType(MediaStore.Images.Media.CONTENT_TYPE)
        startActivityForResult(intent, OPEN_GALLERY)
    }

/*
    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){
            if(requestCode == OPEN_GALLERY){
                var currentImageUri: Uri? = data?.data
                Log.d("이미지 URI", currentImageUri.toString())

                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, currentImageUri)
                var outputStream: OutputStream? = ByteArrayOutputStream()
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
                val byteArray = outputStream.toString().toByteArray()

            } else{Log.d("이미지 가져오기", "실패!")}
        }
    }
    */

    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == OPEN_GALLERY) {
            val imageUri: Uri? = data?.data
            Log.d("이미지 URI", imageUri.toString())
            setContentView(R.layout.activity_button)

            btnYes.setOnClickListener{
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
            //edit_name.text = Editable.Factory.getInstance().newEditable("이현진")
            //edit_studentnum.text = Editable.Factory.getInstance().newEditable("1710235")
            //edit_major.text = Editable.Factory.getInstance().newEditable("ICT융합공학부")



            //quickstart(uri)
        } else {
            Log.d("이미지 가져오기", "실패!")
        }
    }


}