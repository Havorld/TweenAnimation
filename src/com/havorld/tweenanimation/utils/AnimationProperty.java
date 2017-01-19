package com.havorld.tweenanimation.utils;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public class AnimationProperty {

	public static <T extends Animation> T setAnimProperty(T animation){
		// 设置动画播放的时间
		animation.setDuration(3000);
		// 设置动画重复播放的次数
		animation.setRepeatCount(2);
		// 设置动画重复播放的模式
		 
	   //往返：TranslateAnimation.REVERSE ; 从头重复：TranslateAnimation.RESTART
		 
		animation.setRepeatMode(TranslateAnimation.REVERSE);
		
		/**
		 * LinearInterpolator(匀速) 
		 * AccelerateInterpolator(先慢后快)
		 * AccelerateDecelerateInterpolator(先慢中快后慢)
		 * DecelerateInterpolator(先快后慢)
		 * CycleInterpolator(循环播放，速度为正弦曲线)
		 * AnticipateInterpolator(先回撤，再匀速向前)
		 * OvershootInterpolator(超过，拉回)
		 * BounceInterpolator(回弹)
		 */
		// 控制动画先慢后快
		animation.setInterpolator(new AccelerateInterpolator());
		// 设置动画结束后效果保留
//		translateAnimation.setFillAfter(true);
		
		return animation;
		
	}
	
}
