#include <jni.h>
#include <string>
#include <details.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_me_justmambo_libraries_greet_Greet_getGreeting(JNIEnv *env, jobject thiz) {

    string name;

    if (getName().empty()) {
        name = "___________";
    } else {
        name = getName();
    }

    string greeting = "Karibu " + name + " !";
    return env->NewStringUTF(greeting.c_str());
}