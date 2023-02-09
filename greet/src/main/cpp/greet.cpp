#include <jni.h>
#include <string>
#include <details.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_me_justmambo_libraries_greet_Greet_getGreeting(JNIEnv *env, jobject thiz) {
    string greeting = "Karibu " + getName();
    return env->NewStringUTF(greeting.c_str());
}