#!/usr/bin/env bash
echo "Hello World!"
# 变量：注意 shell 中的变量等于号前后不要有空格
a="I am cat"
echo $a

# 数组 & for loop
nums=(1 2 3 4 5 6 7 8 9 10)
declare -i sum=0
for i in ${nums[*]} ; do
    ((sum=sum+i))
done
echo "sum is $sum"

# 条件判断 condition
x=1
y=1
if ((x == y))
then
    echo "x=Y"
elif ((x>y))
then
    echo "x>Y"
else
    echo "x<Y"
fi
# io
curPath=$(pwd)
echo $curPath

# Function
function sum(){
    v1=$1
    v2=$2
    v=$((v1+v2))
    echo $v
}
sum 1 2
s=$(sum 1 2)
echo "s is $s"

#####################
#function is_Digit()
#判断参数是否为数字
#支持浮点数
#只能传入一个参数
#是，返回1，否则返回0
######################
function is_Digit()
{
    ref=`echo $1 |  awk '{print($0~/^[+-]?[0-9]?*(\.[0-9]*)?$/)?"digit":"string"}'`
    if [ "$ref" == "digit" ];then
        return 0;
    else
        return 1;
    fi
}

########################
#function add()
#检查参数，返回两个数字和
########################
function add()
{
    for (( i=1;i<3;i++ ))
    do
        pa="$i"
        if is_Digit ${!pa}
        then
            continue;
        else
            echo "$pa isn't a number";
            return 0;
        fi
    done
    ref=`awk -v num_a=$1 -v num_b=$2 'BEGIN{printf "%d \n",num_a+num_b}'`;
    echo $ref;
}

add 10 10
c=$(add 10 10)
echo "c is $c"

###################
#function multiply()
#判断参数是否为数字
#并将两个参数相乘
#函数直接传入引用
#变量的变量的实现${!para}
#函数的返回值，不能像C一样return，
#需要打印输出，echo
###################
function mul()
{
    for (( i=1;i<3;i++ ))
    do
        pa="$i"
        if is_Digit ${!pa}
        then
            continue;
        else
            echo "$pa isn't a number";
            return 0;
        fi
    done
    ref=`awk -v num_a=$1 -v num_b=$2 'BEGIN{printf "%d \n",num_a*num_b}'`;
    echo $ref;
}
########################
#function div()
#检查参数，返回两个数字差
########################
function div()
{
    for (( i=1;i<3;i++ ))
    do
        pa="$i"
        if is_Digit ${!pa}
        then
            continue;
        else
            echo "$pa isn't a number";
            return 0;
        fi
    done
    ref=`awk -v num_a=$1 -v num_b=$2 'BEGIN{printf "%d \n",num_a/num_b}'`;
    echo $ref;
}

########################
#function sub()
#检查参数，返回两个数字差
########################
function sub()
{
    for (( i=1;i<3;i++ ))
    do
        pa="$i"
        if is_Digit ${!pa}
        then
            continue;
        else
            echo "$pa isn't a number";
            return 0;
        fi
    done
    ref=`awk -v num_a=$1 -v num_b=$2 'BEGIN{printf "%d \n",num_a-num_b}'`;
    echo $ref;
}
###################
#function mul_f()
#判断参数是否为数字
#并将两个参数相乘
#函数直接传入引用
#变量的变量的实现${!para}
#函数的返回值，不能像C一样return，
#需要打印输出，echo
###################
function mul_f()
{
    for (( i=1;i<3;i++ ))
    do
        pa="$i"
        if is_Digit ${!pa}
        then
            continue;
        else
            echo "$pa isn't a number";
            return 0;
        fi
    done
    ref=`awk -v num_a=$1 -v num_b=$2 'BEGIN{printf "%0.2f \n",num_a*num_b}'`;
    echo $ref;
}
########################
#function div_f()
#检查参数，返回两个数字差
########################
function div_f()
{
    for (( i=1;i<3;i++ ))
    do
        pa="$i"
        if is_Digit ${!pa}
        then
            continue;
        else
            echo "$pa isn't a number";
            return 0;
        fi
    done
    ref=`awk -v num_a=$1 -v num_b=$2 'BEGIN{printf "%0.2f \n",num_a/num_b}'`;
    echo $ref;
}
########################
#function add_f()
#检查参数，返回两个数字和
########################
function add_f()
{
    for (( i=1;i<3;i++ ))
    do
        pa="$i"
        if is_Digit ${!pa}
        then
            continue;
        else
            echo "$pa isn't a number";
            return 0;
        fi
    done
    ref=`awk -v num_a=$1 -v num_b=$2 'BEGIN{printf "%0.2f \n",num_a+num_b}'`;
    echo $ref;
}
########################
#function sub_f()
#检查参数，返回两个数字差
########################
function sub_f()
{
    for (( i=1;i<3;i++ ))
    do
        pa="$i"
        if is_Digit ${!pa}
        then
            continue;
        else
            echo "$pa isn't a number";
            return 0;
        fi
    done
    ref=`awk -v num_a=$1 -v num_b=$2 'BEGIN{printf "%0.2f \n",num_a-num_b}'`;
    echo $ref;
}
