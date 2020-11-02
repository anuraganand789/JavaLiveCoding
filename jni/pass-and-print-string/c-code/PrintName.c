#include<stdio.h>
#include "PrintName.h"

JNIEXPORT void JNICALL Java_PrintName_printName
  (JNIEnv *env, jclass this, jstring name){

  const char * myName = (*env)->GetStringUTFChars(env, name, 0);
  printf("My Name is :- %s.\n", myName);
  (*env)->ReleaseStringUTFChars(env, name, myName);
    
}
