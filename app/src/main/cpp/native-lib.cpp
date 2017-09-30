#include <jni.h>
#include <string>
#include <opencv2/core.hpp>
#include <android/log.h>
#include "test_func.h"


using namespace std;
using namespace cv;

vector<int> val_seq;

void test()
{
    int i = 0;

}


int test2(int i){
    i = i +10;
    return i;
}


extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_myandroid_jni_1opcv_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */,
        jint v) {


    // Default test
    //__android_log_print(ANDROID_LOG_DEBUG, "NativeCode", "%s(%d)", __FILE__, __LINE__);
    //std::string hello = "Hello from C++";
    //return env->NewStringUTF(hello.c_str());

    // vector test
    //val_seq.push_back(1);
    //__android_log_print(ANDROID_LOG_DEBUG, "NativeCode", "(%d)", val_seq.size());
    //char val_char[512];
    //sprintf(val_char, "%d", val_seq.size());
    //return env->NewStringUTF(val_char);

    // function test
    int i = test3(val_seq.size());
    val_seq.push_back(1);
    __android_log_print(ANDROID_LOG_DEBUG, "NativeCode", "(%d)", i);
    char val_char[512];
    sprintf(val_char, "%d", i);
    return env->NewStringUTF(val_char);

}


