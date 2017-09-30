//
// Created by Ito Yuichi on 2017/10/01.
//
#include <stdio.h>
#include <stdlib.h>
#include "test_func.h"
#include "test_func2.h"


int test3(int i){
//    i = i-100;
    i = test21(i)-100;
    return i;
}