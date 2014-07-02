/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
#include <string.h>
#include <jni.h>
#include <pthread.h>
#include <android/log.h>
#include "candata.h"
#include "can.h"
#include <stdlib.h>
#include <sys/types.h>
#include <stdio.h>
#include <sys/socket.h>
#include <linux/in.h>
#include <netinet/in.h>
#include <net/if.h>
#define TAG "myDemo-jni" // 这个是自定义的LOG的标识
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,TAG ,__VA_ARGS__) // 定义LOGD类型
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,TAG ,__VA_ARGS__) // 定义LOGI类型
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN,TAG ,__VA_ARGS__) // 定义LOGW类型
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,TAG ,__VA_ARGS__) // 定义LOGE类型
#define LOGF(...) __android_log_print(ANDROID_LOG_FATAL,TAG ,__VA_ARGS__) // 定义LOGF类型
/* This is a trivial JNI example where we use a native method
 * to return a new VM String. See the corresponding Java source
 * file located at:
 *
 *   apps/samples/hello-jni/project/src/com/example/hellojni/HelloJni.java
 */
static int client;
jobject gJniObj;
JavaVM *g_jvm = NULL;
static jclass cls;
static jmethodID mid;
static jmethodID midSetDw1;
static jmethodID midSetDw2;
static jmethodID midSetDw3;
static jmethodID midSetDw5;
static jmethodID midSetDw7;
static jmethodID midSetDw8;
static jmethodID midSetDw9;
static jmethodID midSetDbms1;
static jmethodID midSetDbms2;
static jmethodID midSetDbms3;
static jmethodID midSetDbms4;
static jmethodID midSetDI;
static jmethodID midSetDIN1;
static jmethodID midSetDIN2;
static jmethodID midSetDEM1;
static jmethodID midSetDEM2;
static jmethodID midSetDEM3;
static jmethodID midSetDIC;
static jmethodID midSetDAC;
static jmethodID midSetFA;
static jmethodID midSetDBCM;
//void GetInstance(JNIEnv* env, jclass obj_class);

#define AF_CAN 29
#define PF_CAN AF_CAN
static int mSocket;

void* thread_fun1(void* arg) {
	JNIEnv *env;
	//int mSocket, nbytes;
	int nbytes;
	__u32 id = 0;
	struct can_frame frame_read1;
	if ((*g_jvm)->AttachCurrentThread(g_jvm, &env, NULL) != JNI_OK) {
		LOGD("########## i = %d", 111111111);

		return;
	}

	while (1) {
		mSocket = open_can("can0");
		if (mSocket != -1)
			break;
		sleep(1000);
	}

	jintArray ja_Dw1 = (*env)->NewIntArray(env, 28);
	jintArray ja_Dw9 = (*env)->NewIntArray(env, 14);
	jintArray ja_DEM2 = (*env)->NewIntArray(env, 19);
	jintArray ja_DBCM = (*env)->NewIntArray(env, 37);
	jintArray ja_DIC = (*env)->NewIntArray(env, 17);
	while (1) {
		nbytes = recv_can(mSocket, &frame_read1);
		id = frame_read1.can_id & 0x7fffffff;
		switch (id) {
		case 0X0CFF0A4A:
			handleDw1(env, (controller_send_data1 *) &(frame_read1.data),
					ja_Dw1);
			break;

		case 0x0CFF0B4A:
			handleDw2(env, (controller_send_data1 *) &frame_read1.data);
			break;

		case 0x0CFF0C4A:
			handleDw3(env, (controller_send_data1 *) &frame_read1.data);
			break;

		case 0x0CFF0E4A:
			handleDw5(env, (controller_send_data1 *) &frame_read1.data);
			break;

		case 0x0CFF104A:
			handleDw7(env, (controller_send_data1 *) &frame_read1.data);
			break;

		case 0x0CFF324A:
			handleDw8(env, (controller_send_data1 *) &frame_read1.data);
			break;

		case 0x0CFFEB4A:
			handleDw9(env, (controller_send_data1 *) &frame_read1.data, ja_Dw9);
			break;

		case 0x18FF2C47:
			handleDEM1(env, (dynamo_send_data1 *) &frame_read1.data);
			break;

		case 0x18FF2D47:
			handleDEM2(env, (dynamo_send_data1 *) &frame_read1.data, ja_DEM2);
			break;

		case 0x18FF2E47:
			handleDEM3(env, (dynamo_send_data1 *) &frame_read1.data);
			break;

		case 0x18FF2848:
			handleDBMS1(env, (battery_send_data1 *) &frame_read1.data);
			break;

		case 0x18FF2948:
			handleDBMS2(env, (battery_send_data1 *) &frame_read1.data);
			break;

		case 0x18FF2A48:
			handleDBMS3(env, (battery_send_data1 *) &frame_read1.data);
			break;

		case 0x18FF2B48:
			handleDBMS4(env, (battery_send_data1 *) &frame_read1.data);
			break;

		case 0x18FF5A52:
			handleDFA(env, (fire_alarm_send_data *) &frame_read1.data);
			break;

		case 0x18FF0150:
			handleDIC(env, (pdc_brocast_send_data *) &frame_read1.data, ja_DIC);
			break;

		case 0x18FF2B49:
			handleDI(env, (insulation_detect_send_data *) &frame_read1.data);
			break;

		case 0x18FF6E53:
			handleDBCM(env, (main_can_module_send_data *) &frame_read1.data,
					ja_DBCM);
			break;

		default:
			break;
		}
	}

	pthread_exit(0);

}
void* thread_fun2(void* arg) {
	JNIEnv *env;
	int mSocket, nbytes;
	struct can_frame frame_read2;
	if ((*g_jvm)->AttachCurrentThread(g_jvm, &env, NULL) != JNI_OK) {
		LOGD("########## i = %d", 111111111);
		return;
	}
	while (1) {
		mSocket = open_can("can1");
		if (mSocket != -1)
			break;
		sleep(1000);
	}
	while (1) {
		nbytes = recv_can(mSocket, frame_read2);

	}
	pthread_exit(0);
}
void CreateThread(JNIEnv* env, jobject mainactivity) {
	pthread_t *pt1, *pt2;
	pt1 = (pthread_t*) malloc(sizeof(pthread_t));
	pthread_create(pt1, NULL, thread_fun1, NULL);
	//pt2 = (pthread_t*) malloc(sizeof(pthread_t));
	//pthread_create(pt2, NULL, thread_fun2, NULL);
}
int open_can(char *ifname) {
	int mSocket;
	struct sockaddr_can addr;
	struct ifreq ifr;

	if ((mSocket = socket(PF_CAN, SOCK_RAW, CAN_RAW)) < 0) {
		//LOGD("%s \n", "Error while opening socket.");
		return -1;
	}

	strcpy(ifr.ifr_name, ifname);
	ioctl(mSocket, SIOCGIFINDEX, &ifr);

	addr.can_family = AF_CAN;
	addr.can_ifindex = ifr.ifr_ifindex;
	//LOGD("%s is at index  %d \n", ifname, ifr.ifr_ifindex);
	if (bind(mSocket, (struct sockaddr *) &addr, sizeof(addr)) < 0) {
		//LOGD("%s \n", "Error in socket bind.");
		return -1;
	}
	//LOGD("mSocket is: %d \n", mSocket);
	return mSocket;
}

int recv_can(int socket, struct can_frame *frame) {
	int i, nbytes;
	nbytes = read(socket, frame, sizeof(struct can_frame));
	if (nbytes < 0) {
		//LOGD("%s \n", "read failed.");
		return -1;
	}
	if (nbytes < sizeof(struct can_frame)) {
		//LOGD("%s \n", "read: incomplete CAN frame.");
		return -1;
	}
	if (nbytes == sizeof(struct can_frame)) {
		/*for (i = 0; i < frame->can_dlc; i++) {
		 //LOGD("%x \n", frame->data[i]);
		 }*/
		//LOGD("\n");
	}

	return nbytes;
}
int send_can(int socket, struct can_frame *frame) {
	int nbytes;
	nbytes = write(socket, frame, sizeof(struct can_frame));
	if (nbytes < 0) {
		LOGD("%s \n", "send failed.");
		return -1;
	}
	if (nbytes < sizeof(struct can_frame)) {
		LOGD("%s \n", "send: incomplete CAN frame.");
		return -1;
	}
	LOGD("Wrote %d bytes. \n", nbytes);
	return nbytes;
}

JNIEXPORT void JNICALL Java_com_mark_bus_data_DataHandler_setAC(JNIEnv* env, jobject thiz,jint fengsudangwei,jint wendu,jint songfengmoshi,jint gongzuomoshi,jfloat gonglv,jint gongzuoshineng) {
	screen_send2ac_data ss2acd = {};

	ss2acd.wind_speed_position =fengsudangwei;
	ss2acd.temperature =(wendu+40)*2;
	ss2acd.ac_wind_mode =songfengmoshi;
	ss2acd.ac_mode = gongzuomoshi;
	ss2acd.ac_power =(int)(gonglv*10.0f);
	ss2acd.ac_switch =gongzuoshineng;
	struct can_frame frame = {
		.can_id = 0x98FF6451,
		.can_id = 0x98FF7854,
		.can_dlc = 8
	};
	char *p = (char*) &frame;
	memcpy( p+8,&ss2acd,8);
	send_can(mSocket,&frame);

}

JNIEXPORT void JNICALL Java_com_mark_bus_data_DataHandler_setButtons(JNIEnv* env, jobject thiz,jintArray buttons) {
	jsize len = (*env)->GetArrayLength(env, buttons);
	jint *body = (*env)->GetIntArrayElements(env, buttons, 0);
	srceen_send2_can_data ss2cd = {};
	ss2cd.front_fog_light = 1;
	ss2cd.rear_fog_light =1;
	ss2cd.rear_fog_light =1;
	ss2cd.top_single_light =1;
	ss2cd.top_double_light =1;
	ss2cd.tv_power =1;
	ss2cd.luggage_shelf_light =1;
	ss2cd.luggage_compartment_light =1;
	ss2cd.tv_power =1;
	ss2cd.tv_power =1;

	struct can_frame frame = {
		.can_id = 0x98FF7854,
		.can_dlc = 8
	};
	char *p = (char*) &frame;
	memcpy( p+8,&ss2cd,8);

	send_can(mSocket,&frame);

}

JNIEXPORT void JNICALL Java_com_mark_bus_data_DataHandler_initialize(JNIEnv* env, jobject thiz) {

	(*env)->GetJavaVM(env, &g_jvm);

	cls = (*env)->FindClass(env, "com/mark/bus/data/DataHandler1");

	mid = (*env)->GetStaticMethodID(env, cls, "testd", "()V");

	midSetDw1 = (*env)->GetStaticMethodID(env, cls, "setDw1", "([IFF)V");
	midSetDw2 = (*env)->GetStaticMethodID(env, cls, "setDw2", "(IIIFF)V");
	midSetDw3 = (*env)->GetStaticMethodID(env, cls, "setDw3", "(IFFF)V");
	midSetDw5 = (*env)->GetStaticMethodID(env, cls, "setDw5", "(IFIIFI)V");
	midSetDw7 = (*env)->GetStaticMethodID(env, cls, "setDw7", "(IIIIIII)V");
	midSetDw8 = (*env)->GetStaticMethodID(env, cls, "setDw8", "(FIF)V");
	midSetDw9 = (*env)->GetStaticMethodID(env, cls, "setDw9", "([I)V");

	midSetDbms1 = (*env)->GetStaticMethodID(env, cls, "setBMS1", "(FFFIIIIIIIIII)V");
	midSetDbms2= (*env)->GetStaticMethodID(env, cls, "setBMS2", "(IIIIIIIII)V");
	midSetDbms3= (*env)->GetStaticMethodID(env, cls, "setBMS3", "(IIIIIIF)V");
	midSetDbms4 = (*env)->GetStaticMethodID(env, cls, "setBMS4", "(FF)V");

	midSetDI = (*env)->GetStaticMethodID(env, cls, "setDI", "(IIII)V");

	midSetDIN1 = (*env)->GetStaticMethodID(env, cls, "setDIN1", "(IIII)V");
	midSetDIN2 = (*env)->GetStaticMethodID(env, cls, "setDIN2", "(I)V");

	midSetDEM1 = (*env)->GetStaticMethodID(env, cls, "setDEM1", "(IIIIIIIII)V");
	midSetDEM2 = (*env)->GetStaticMethodID(env, cls, "setDEM2", "([I)V");
	midSetDEM3 = (*env)->GetStaticMethodID(env, cls, "setDEM3", "(FFFF)V");

	midSetDIC =(*env)->GetStaticMethodID(env, cls, "setDIC", "([IF)V");
	midSetDAC = (*env)->GetStaticMethodID(env, cls, "setDAC", "(IIIIIFF)V");

	midSetFA = (*env)->GetStaticMethodID(env, cls, "setDFA", "(IIIII)V");
	midSetDBCM = (*env)->GetStaticMethodID(env, cls, "setDBCM", "([I)V");
	CreateThread(env, thiz);
}

void handleDBCM(JNIEnv *env, main_can_module_send_data * pcm,
		jintArray jintarray) {
	(*env)->SetObjectArrayElement(env, jintarray, 0,
			(jobject)((int) (pcm->relay_power)));
	(*env)->SetObjectArrayElement(env, jintarray, 1,
			(jobject)((int) (pcm->wc_light)));
	(*env)->SetObjectArrayElement(env, jintarray, 2,
			(jobject)((int) (pcm->rear_compartment_door_inductive_switch)));
	(*env)->SetObjectArrayElement(env, jintarray, 3,
			(jobject)((int) (pcm->wc_force_pollution_discharge)));
	(*env)->SetObjectArrayElement(env, jintarray, 4,
			(jobject)((int) (pcm->relay)));
	(*env)->SetObjectArrayElement(env, jintarray, 5,
			(jobject)((int) (pcm->back_light)));
	(*env)->SetObjectArrayElement(env, jintarray, 6,
			(jobject)((int) (pcm->break_light)));
	(*env)->SetObjectArrayElement(env, jintarray, 7,
			(jobject)((int) (pcm->rear_fog_light)));
	(*env)->SetObjectArrayElement(env, jintarray, 8,
			(jobject)((int) (pcm->luggage_shelf_light)));
	(*env)->SetObjectArrayElement(env, jintarray, 9,
			(jobject)((int) (pcm->top_blue_light)));
	(*env)->SetObjectArrayElement(env, jintarray, 10,
			(jobject)((int) (pcm->turn_right_light)));
	(*env)->SetObjectArrayElement(env, jintarray, 11,
			(jobject)((int) (pcm->turn_left_light)));
	(*env)->SetObjectArrayElement(env, jintarray, 12,
			(jobject)((int) (pcm->drive_top_light)));
	(*env)->SetObjectArrayElement(env, jintarray, 13,
			(jobject)((int) (pcm->top_double_light)));
	(*env)->SetObjectArrayElement(env, jintarray, 14,
			(jobject)((int) (pcm->top_single_light)));
	(*env)->SetObjectArrayElement(env, jintarray, 15,
			(jobject)((int) (pcm->read_light)));
	(*env)->SetObjectArrayElement(env, jintarray, 16,
			(jobject)((int) (pcm->mid_door_on)));
	(*env)->SetObjectArrayElement(env, jintarray, 17,
			(jobject)((int) (pcm->mid_door_off)));
	(*env)->SetObjectArrayElement(env, jintarray, 18,
			(jobject)((int) (pcm->tv_power)));
	(*env)->SetObjectArrayElement(env, jintarray, 19,
			(jobject)((int) (pcm->wc_occupied)));
	(*env)->SetObjectArrayElement(env, jintarray, 20,
			(jobject)((int) (pcm->mid_step)));
	(*env)->SetObjectArrayElement(env, jintarray, 21,
			(jobject)((int) (pcm->right_luggage_compartment_light)));
	(*env)->SetObjectArrayElement(env, jintarray, 22,
			(jobject)((int) (pcm->left_luggage_compartment_light)));
	(*env)->SetObjectArrayElement(env, jintarray, 23,
			(jobject)((int) (pcm->wiper_slow)));
	(*env)->SetObjectArrayElement(env, jintarray, 24,
			(jobject)((int) (pcm->height_show)));
	(*env)->SetObjectArrayElement(env, jintarray, 25,
			(jobject)((int) (pcm->trumpet_switch)));
	(*env)->SetObjectArrayElement(env, jintarray, 26,
			(jobject)((int) (pcm->ac_switch)));
	(*env)->SetObjectArrayElement(env, jintarray, 27,
			(jobject)((int) (pcm->wiper_quick)));
	(*env)->SetObjectArrayElement(env, jintarray, 28,
			(jobject)((int) (pcm->front_trun_right_light)));
	(*env)->SetObjectArrayElement(env, jintarray, 29,
			(jobject)((int) (pcm->front_trun_left_light)));
	(*env)->SetObjectArrayElement(env, jintarray, 30,
			(jobject)((int) (pcm->warter_electric_mechine)));
	(*env)->SetObjectArrayElement(env, jintarray, 31,
			(jobject)((int) (pcm->front_door_off)));
	(*env)->SetObjectArrayElement(env, jintarray, 32,
			(jobject)((int) (pcm->front_door_on)));
	(*env)->SetObjectArrayElement(env, jintarray, 33,
			(jobject)((int) (pcm->near_light)));
	(*env)->SetObjectArrayElement(env, jintarray, 34,
			(jobject)((int) (pcm->front_fog)));
	(*env)->SetObjectArrayElement(env, jintarray, 35,
			(jobject)((int) (pcm->far_light)));
	(*env)->SetObjectArrayElement(env, jintarray, 36,
			(jobject)((int) (pcm->front_step_light)));

	(*env)->CallStaticVoidMethod(env, cls, midSetDBCM, jintarray);

}
void handleDFA(JNIEnv *env, fire_alarm_send_data * pfa) {
	int i1 = (int) pfa->device_status;
	int i2 = (int) pfa->sensor_communication;
	int i3 = (int) pfa->sensor_block;
	int i4 = (int) pfa->sensor_issue;
	int i5 = (int) pfa->life_signal;
	(*env)->CallStaticVoidMethod(env, cls, midSetFA, i1, i2, i3, i4, i5);

}
void handleDAC(JNIEnv *env, ac_can_send_data * pac) {
	int i1 = (int) pac->issue_code;
	int i2 = (int) pac->cur_wind_speed;
	int i3 = (int) pac->ac_wind_mode;
	int i4 = (int) pac->ac_mode;
	int i5 = (int) pac->ac_switch;
	float f1 = pac->cur_inner_temperature * 0.5f - 40.0f;
	float f2 = pac->ac_power * 0.1f;
	(*env)->CallStaticVoidMethod(env, cls, midSetDAC, i1, i2, i3, i4, i5, f1,
			f2);

}
void handleDIC(JNIEnv *env, pdc_brocast_send_data * ppbs, jintArray jintarray) {
	(*env)->SetObjectArrayElement(env, jintarray, 0,
			(jobject)((int) (ppbs->main_power_output_status)));
	(*env)->SetObjectArrayElement(env, jintarray, 1,
			(jobject)((int) (ppbs->ac_relay_output_status)));
	(*env)->SetObjectArrayElement(env, jintarray, 2,
			(jobject)((int) (ppbs->defrost_relay_output_status)));
	(*env)->SetObjectArrayElement(env, jintarray, 3,
			(jobject)((int) (ppbs->high_pressure_light_status)));
	(*env)->SetObjectArrayElement(env, jintarray, 4,
			(jobject)((int) (ppbs->main_contactor_output_status)));
	(*env)->SetObjectArrayElement(env, jintarray, 5,
			(jobject)((int) (ppbs->precharge_contactor_output_status)));
	(*env)->SetObjectArrayElement(env, jintarray, 6,
			(jobject)(
					(int) (ppbs->main_power_precharge_contacor_output_status)));
	(*env)->SetObjectArrayElement(env, jintarray, 7,
			(jobject)((int) (ppbs->recharge_relay_output_status)));

	(*env)->SetObjectArrayElement(env, jintarray, 8,
			(jobject)((int) (ppbs->main_power_contactor_feedback_status)));

	(*env)->SetObjectArrayElement(env, jintarray, 9,
			(jobject)((int) (ppbs->ac_relay_feedback_status)));
	(*env)->SetObjectArrayElement(env, jintarray, 10,
			(jobject)((int) (ppbs->defrost_relay_feedback_status)));
	(*env)->SetObjectArrayElement(env, jintarray, 11,
			(jobject)((int) (ppbs->high_pressure_light_feedback_status)));
	(*env)->SetObjectArrayElement(env, jintarray, 12,
			(jobject)((int) (ppbs->main_contactor_feedback_status)));
	(*env)->SetObjectArrayElement(env, jintarray, 13,
			(jobject)((int) (ppbs->precharge_contactor_feedback_status)));
	(*env)->SetObjectArrayElement(env, jintarray, 14,
			(jobject)(
					(int) (ppbs->main_power_precharge_contacor_feedback_status)));

	(*env)->SetObjectArrayElement(env, jintarray, 15,
			(jobject)((int) (ppbs->recharge_relay_feedback_status)));
	(*env)->SetObjectArrayElement(env, jintarray, 16,
			(jobject)((int) (ppbs->can_life_signal)));

	float f1 = (ppbs->total_electric_current_high_byte * 256
			+ ppbs->total_electric_current_low_byte) * 0.1f - 3200.0f;

	(*env)->CallStaticVoidMethod(env, cls, midSetDIC, jintarray, f1);

}
void handleDEM3(JNIEnv *env, dynamo_send_data3 * pdem3) {
	float f1 =
			(pdem3->dynamo_max_drive_high * 256 + pdem3->dynamo_max_drive_low)
					* 0.1f;
	float f2 =
			(pdem3->dynamo_max_break_high * 256 + pdem3->dynamo_max_break_low)
					* 0.1f;
	float f3 = (pdem3->dynamo_max_drive_torque_high * 256
			+ pdem3->dynamo_max_drive_torque_low) * 0.1f;
	float f4 = (pdem3->dynamo_max_break_torque_high * 256
			+ pdem3->dynamo_max_break_torque_low) * 0.1f;
	(*env)->CallStaticVoidMethod(env, cls, midSetDEM3, f1, f2, f3, f4);

}

void handleDEM2(JNIEnv *env, dynamo_send_data2 * pdem2, jintArray jintarray) {

	(*env)->SetObjectArrayElement(env, jintarray, 0,
			(jobject)((int) (pdem2->controller_temperature - 40)));
	(*env)->SetObjectArrayElement(env, jintarray, 1,
			(jobject)((int) (pdem2->dynamo_temperature - 40)));
	(*env)->SetObjectArrayElement(env, jintarray, 2,
			(jobject)(
					(int) (pdem2->dynamo_rpm_high * 256 + pdem2->dynamo_rpm_low)));
	(*env)->SetObjectArrayElement(env, jintarray, 3,
			(jobject)((int) pdem2->dynamo_controller_over_heat));
	(*env)->SetObjectArrayElement(env, jintarray, 4,
			(jobject)((int) pdem2->dynamo_controller_less_pressure));
	(*env)->SetObjectArrayElement(env, jintarray, 5,
			(jobject)((int) pdem2->dynamo_controller_over_speed));
	(*env)->SetObjectArrayElement(env, jintarray, 6,
			(jobject)((int) pdem2->dynamo_controller_over_load));

	(*env)->SetObjectArrayElement(env, jintarray, 7,
			(jobject)((int) pdem2->switch_logic_check));

	(*env)->SetObjectArrayElement(env, jintarray, 8,
			(jobject)((int) pdem2->foot_break_alarm));
	(*env)->SetObjectArrayElement(env, jintarray, 9,
			(jobject)((int) pdem2->contactor_point_issue));
	(*env)->SetObjectArrayElement(env, jintarray, 10,
			(jobject)((int) pdem2->power_on_neutral_position_check_issue));
	(*env)->SetObjectArrayElement(env, jintarray, 11,
			(jobject)((int) pdem2->direct_current_over_press));
	(*env)->SetObjectArrayElement(env, jintarray, 12,
			(jobject)((int) pdem2->igbt_issue));
	(*env)->SetObjectArrayElement(env, jintarray, 13,
			(jobject)((int) pdem2->dynamo_controller_over));
	(*env)->SetObjectArrayElement(env, jintarray, 14,
			(jobject)((int) pdem2->controller_electirc_less_press));
	(*env)->SetObjectArrayElement(env, jintarray, 15,
			(jobject)((int) pdem2->dynamo_controller_over_press));
	(*env)->SetObjectArrayElement(env, jintarray, 16,
			(jobject)((int) pdem2->high_footboard_issue));
	(*env)->SetObjectArrayElement(env, jintarray, 17,
			(jobject)((int) pdem2->hand_break_alarm));
	(*env)->SetObjectArrayElement(env, jintarray, 18,
			(jobject)((int) pdem2->ready_signal));
	(*env)->CallStaticVoidMethod(env, cls, midSetDEM2, jintarray);

}
void handleDEM1(JNIEnv *env, dynamo_send_data1 * pdem1) {
	int i1 = pdem1->main_contactor;
	int i2 = pdem1->dynamo;
	int i3 = pdem1->power;
	int i4 = pdem1->mode;
	int i5 = pdem1->nr;
	int i6 = pdem1->state;
	int i7 = pdem1->dynamo_current_high * 256 + pdem1->dynamo_current_low;
	int i8 = pdem1->dynamo_controller_voltage_high * 256
			+ pdem1->dynamo_controller_voltage_low;
	int i9 = pdem1->dynamo_cur_torque_high * 256 + pdem1->dynamo_cur_torque_low;
	(*env)->CallStaticVoidMethod(env, cls, midSetDEM1, i1, i2, i3, i4, i5, i6,
			i7, i8, i9);

}
void handleDIN2(JNIEnv *env, instrument_send_data2 * pdin2) {
	(*env)->CallStaticVoidMethod(env, cls, midSetDIN2,
			(int) pdin2->trip_milestone_zero_flag);
}
void handleDIN1(JNIEnv *env, instrument_send_data1 * pdin1) {
	(*env)->CallStaticVoidMethod(env, cls, midSetDIN1, (int) pdin1->back_door,
			(int) pdin1->front_door, (int) pdin1->mid_door,
			(int) pdin1->rear_door);

}

void handleDI(JNIEnv *env, insulation_detect_send_data * pdi) {
	int i1 = (int) pdi->status;
	int i2 = (int) pdi->alarm;
	int i3 = pdi->insulation_resistance_high * 256
			+ pdi->insulation_resistance_low;
	int i4 = pdi->life_signal;
	(*env)->CallStaticVoidMethod(env, cls, midSetDI, i1, i2, i3, i4);

}
void handleDBMS4(JNIEnv *env, battery_send_data4 * pdbms4) {
	float f1 = (pdbms4->recharge_high * 256 + pdbms4->recharge_low) * 0.1f
			- 3200.0f;
	float f2 = (pdbms4->discharge_high * 256 + pdbms4->discharge_low) * 0.1f
			- 3200.0f;
	(*env)->CallStaticVoidMethod(env, cls, midSetDbms4, f1, f2);
}
void handleDBMS3(JNIEnv *env, battery_send_data3 * pdbms3) {

	float f1 = (pdbms3->power_left_high * 256 + pdbms3->power_left_low) * 0.01f;
	(*env)->CallStaticVoidMethod(env, cls, midSetDbms3,
			(int) pdbms3->low_press_battery_count,
			(int) pdbms3->high_press_battery_count,
			(int) pdbms3->battery_position_by_press_low,
			(int) pdbms3->battery_position_by_press_high,
			(int) pdbms3->battery_position_by_temperature_low,
			(int) pdbms3->battery_position_by_temperature_high, f1);
}
void handleDBMS2(JNIEnv *env, battery_send_data2 * pdbms2) {
	int i1 = pdbms2->battery_min_press_high * 256
			+ pdbms2->battery_min_press_low;
	int i2 = pdbms2->battery_max_press_high * 256
			+ pdbms2->battery_max_press_low;
	int i3 = (int) pdbms2->battery_max_temperature;
	int i4 = (int) pdbms2->battery_temperatue_range;
	int i5 = (int) pdbms2->bms_issue;
	int i6 = (int) pdbms2->over_heat_issue;
	int i7 = (int) pdbms2->temperature_balance_issue;
	int i8 = (int) pdbms2->voltage_balance_issue;
	int i9 = (int) pdbms2->battery_count;
	(*env)->CallStaticVoidMethod(env, cls, midSetDbms2, i1, i2, i3, i4, i5, i6,
			i7, 8, i9);
}

;

void handleDBMS1(JNIEnv *env, battery_send_data1 * dbms1) {
	float f1 = (dbms1->battery_realtime_voltage_high * 256
			+ dbms1->battery_realtime_voltage_low) * 0.1f;
	float f2 = (dbms1->battery_realtime_current_high * 256
			+ dbms1->battery_realtime_current_low) * 0.1f;
	float f3 = dbms1->battery_soc * 0.4f;

	int i1 = (int) dbms1->module_voltage_high;
	int i2 = (int) dbms1->module_voltage_low;
	int i3 = (int) dbms1->soc_high;
	int i4 = (int) dbms1->soc_low;
	int i5 = (int) dbms1->overload;
	int i6 = (int) dbms1->temeperature_high_stop;
	int i7 = (int) dbms1->soc_high_stop;
	int i8 = (int) dbms1->mismatch;
	int i9 = (int) dbms1->charge_stake_connect_flag;
	int i10 = (int) dbms1->charge_forbbiden_flag;
	(*env)->CallStaticVoidMethod(env, cls, midSetDbms1, f1, f2, f3, i1, i2, i3,
			i4, i5, i6, i7, 8, i9, i10);
}

void handleDw9(JNIEnv *env, controller_send_date9 * pdw9, jintArray jintarray) {
	(*env)->SetObjectArrayElement(env, jintarray, 0,
			(jobject)((int) pdw9->charge_relay));
	(*env)->SetObjectArrayElement(env, jintarray, 1,
			(jobject)((int) pdw9->air_pump));
	(*env)->SetObjectArrayElement(env, jintarray, 2,
			(jobject)((int) pdw9->water_pump));
	(*env)->SetObjectArrayElement(env, jintarray, 3,
			(jobject)((int) pdw9->fan2));
	(*env)->SetObjectArrayElement(env, jintarray, 4,
			(jobject)((int) pdw9->fan1));
	(*env)->SetObjectArrayElement(env, jintarray, 5, (jobject)((int) pdw9->ac));
	(*env)->SetObjectArrayElement(env, jintarray, 6,
			(jobject)((int) pdw9->high_pressure_already_closed));
	(*env)->SetObjectArrayElement(env, jintarray, 7,
			(jobject)((int) pdw9->high_pressure_close_command));
	(*env)->SetObjectArrayElement(env, jintarray, 8,
			(jobject)((int) pdw9->precharge_already_closed));
	(*env)->SetObjectArrayElement(env, jintarray, 9,
			(jobject)((int) pdw9->precharge_close_command));
	(*env)->SetObjectArrayElement(env, jintarray, 10,
			(jobject)((int) pdw9->key_start));
	(*env)->SetObjectArrayElement(env, jintarray, 11,
			(jobject)((int) pdw9->receive_wane_close_signal));
	(*env)->SetObjectArrayElement(env, jintarray, 12,
			(jobject)((int) pdw9->key_on_signal));
	(*env)->SetObjectArrayElement(env, jintarray, 13,
			(jobject)(
					(int) (pdw9->charge_left_time_high * 256
							+ pdw9->charge_left_time_low)));

	(*env)->CallStaticVoidMethod(env, cls, midSetDw9, jintarray);
}
void handleDw8(JNIEnv *env, controller_send_date8 * pdw8) {
	float f1 = (pdw8->cur_mile_high * 256 + pdw8->cur_mile_low) * 0.1f;
	int i1 = (int) pdw8->total_mile;
	float f2 = (pdw8->availid_mile_high * 256 + pdw8->availid_mile_low) * 0.1f;
	(*env)->CallStaticVoidMethod(env, cls, midSetDw8, f1, i1, f2);
}
void handleDw7(JNIEnv *env, controller_send_date7 * pdw7) {

	(*env)->CallStaticVoidMethod(env, cls, midSetDw7,
			(int) pdw7->charge_contactor_close_apply_signal,
			(int) pdw7->defrost_relay_close_apply_signal,
			(int) pdw7->ac_relay_close_apply_signal,
			(int) pdw7->main_contactor_close_apply_signal,
			(int) pdw7->precharge_contactor_close_apply_signal,
			(int) pdw7->power_contactor_close_apply_signal,
			(int) pdw7->power_precharge_contactor_close_apply_signal);

}
void handleDw5(JNIEnv *env, controller_send_date5 * pdw5) {

	int i1 = (int) pdw5->wind_speed_position;
	float f1 = pdw5->temperature * 0.1f;
	int i2 = (int) pdw5->ac_wind_mode;
	int i3 = (int) pdw5->ac_mode;
	float f2 = pdw5->ac_power * 0.5f - 40.0f;
	int i4 = (int) pdw5->ac_on;
	(*env)->CallStaticVoidMethod(env, cls, midSetDw5, i1, f1, i2, i3, f2, i4);

}

void handleDw3(JNIEnv *env, controller_send_date3 * pdw3) {
	int i1 = (int) pdw3->consume_since_last_charge_high * 256
			+ (int) pdw3->consume_since_last_charge_low;
	float f1 = (pdw3->bus_air_press_high * 256 + pdw3->bus_air_press_low) * 0.1f
			- 300.0f;
	float f2 = (pdw3->present_power_high * 256 + pdw3->present_power_low)
			* 0.1f;
	float f3 = (pdw3->realtime_speed_high * 256 + pdw3->realtime_speed_low)
			* 0.1f;
	(*env)->CallStaticVoidMethod(env, cls, midSetDw3, i1, f1, f2, f3);

}
void handleDw2(JNIEnv *env, controller_send_date2 * pdw2) {

	float f1 = (pdw2->break_signal_high * 256 + pdw2->break_signal_low) * 0.1f;
	float f2 = (pdw2->accelerator_signal_high * 256
			+ pdw2->accelerator_signal_low) * 0.1f;
	(*env)->CallStaticVoidMethod(env, cls, midSetDw2,
			(int) pdw2->alarm_light_signal, (int) pdw2->issue_light_signal,
			(int) pdw2->ready_light_signal, f1, f2);

}

void handleDw1(JNIEnv *env, controller_send_data1 * pdw1, jintArray ja) {
	jfloat bus_air_press = (((int) pdw1->bus_air_press_high) * 256
			+ (int) pdw1->bus_air_press_low) * 0.01f;
	jfloat dynamo_torque = (((int) pdw1->dynamo_torque_high) * 256
			+ (int) pdw1->dynamo_torque_low) * 0.1f;

	(*env)->SetObjectArrayElement(env, ja, 0,
			(jobject)((int) pdw1->high_press_wane_close));
	(*env)->SetObjectArrayElement(env, ja, 1, (jobject)((int) pdw1->key_st));

	(*env)->SetObjectArrayElement(env, ja, 2, (jobject)((int) pdw1->key_on));
	(*env)->SetObjectArrayElement(env, ja, 3, (jobject)((int) pdw1->key_acc));
	(*env)->SetObjectArrayElement(env, ja, 4,
			(jobject)((int) pdw1->revolution_status));
	(*env)->SetObjectArrayElement(env, ja, 5,
			(jobject)((int) pdw1->revolution_mode));
	(*env)->SetObjectArrayElement(env, ja, 6,
			(jobject)((int) pdw1->contactor_status));
	(*env)->SetObjectArrayElement(env, ja, 7,
			(jobject)((int) pdw1->battery_temperatue_over_low));
	(*env)->SetObjectArrayElement(env, ja, 8,
			(jobject)((int) pdw1->battery_temperatue_over_high));
	(*env)->SetObjectArrayElement(env, ja, 9,
			(jobject)((int) pdw1->battery_charge_current_over));
	(*env)->SetObjectArrayElement(env, ja, 10,
			(jobject)((int) pdw1->battery_discharge_current_over));

	(*env)->SetObjectArrayElement(env, ja, 11,
			(jobject)((int) pdw1->single_battery_vlotage_over_low));

	(*env)->SetObjectArrayElement(env, ja, 12,
			(jobject)((int) pdw1->single_battery_vlotage_over_high));

	(*env)->SetObjectArrayElement(env, ja, 13,
			(jobject)((int) pdw1->battery_vlotage_over_low));

	(*env)->SetObjectArrayElement(env, ja, 14,
			(jobject)((int) pdw1->battery_vlotage_over_high));

	(*env)->SetObjectArrayElement(env, ja, 15,
			(jobject)((int) pdw1->dynano_break_priority));

	(*env)->SetObjectArrayElement(env, ja, 16, (jobject)((int) pdw1->idling));

	(*env)->SetObjectArrayElement(env, ja, 17,
			(jobject)((int) pdw1->break_singal));

	(*env)->SetObjectArrayElement(env, ja, 18, (jobject)((int) pdw1->n));

	(*env)->SetObjectArrayElement(env, ja, 19, (jobject)((int) pdw1->d));

	(*env)->SetObjectArrayElement(env, ja, 20, (jobject)((int) pdw1->r));

	(*env)->SetObjectArrayElement(env, ja, 21, (jobject)((int) pdw1->p));

	(*env)->SetObjectArrayElement(env, ja, 22,
			(jobject)((int) pdw1->air_press_sensor_alarm));

	(*env)->SetObjectArrayElement(env, ja, 23,
			(jobject)((int) pdw1->standard_parameter_check_issue));

	(*env)->SetObjectArrayElement(env, ja, 24,
			(jobject)((int) pdw1->water_low));

	(*env)->SetObjectArrayElement(env, ja, 25,
			(jobject)((int) pdw1->water_pump));

	(*env)->SetObjectArrayElement(env, ja, 26, (jobject)((int) pdw1->ac));

	(*env)->SetObjectArrayElement(env, ja, 27,
			(jobject)((int) pdw1->break_availid));
	(*env)->CallStaticVoidMethod(env, cls, midSetDw1, ja, bus_air_press,
			dynamo_torque);

// jint *body= (*env)->GetIntArrayElements(env,*pja,0);
// (*env)->ReleaseIntArrayElements(env, *pja, body,0);
}

/*
 void GetInstance(JNIEnv* env, jclass obj_class) {
 jmethodID construction_id = (*env)->GetMethodID(env, obj_class, "<init>",
 "()V");
 gJniObj = (*env)->NewObject(env, obj_class, construction_id);
 }
 */
/*
 JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *reserved) {
 JNIEnv* env = NULL;
 jint result = -1;
 if ((*vm)->GetEnv(vm, (void**) &env, JNI_VERSION_1_4) != JNI_OK) {
 LOGD("########## i = %d", 2);
 return result;
 }
 LOGD("########## i = %d", 3);
 return JNI_VERSION_1_4;

 }
 */

