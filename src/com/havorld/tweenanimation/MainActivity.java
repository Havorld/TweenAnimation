package com.havorld.tweenanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.havorld.tweenanimation.utils.AnimationProperty;
/**
 *  
 *  五种补间动画：
 
    AlphaAnimation：透明度（alpha）渐变效果

	TranslateAnimation：位移渐变，需要指定移动点的开始和结束坐标

	ScaleAnimation：缩放渐变，可以指定缩放的参考点

	RotateAnimation：旋转渐变，可以指定旋转的参考点

	AnimationSet：组合渐变，支持组合多种渐变效果
 *
 */
public class MainActivity extends Activity {

	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		imageView = (ImageView) findViewById(R.id.iv);
	}

	/**
	 * 平移动画
	 */
	public void trans(View view) {

		/**
		 * 
		 * float fromXDelta 动画开始的点离当前View X坐标上的差值 
		 * float toXDelta 动画结束的点离当前View X坐标上的差值
		 * float fromYDelta 动画开始的点离当前View Y坐标上的差值 
		 * float toYDelta  动画开始的点离当前View Y坐标上的差值
		 * 
		 */
		//X轴上移动100px,Y轴上移动300px
		// TranslateAnimation translateAnimation=new TranslateAnimation(0, 100, 0, 300);

		 
//		fromXType:相对于哪个控件横向移动;fromXValue 从哪个位置开始横向移动
//		toXType:移动到相对于哪个控件的位置 ;toXValue 移动到的横向最终位置
//		TranslateAnimation(int fromXType, float fromXValue, 
//						   int toXType, float toXValue, 
//						   int fromYType, float fromYValue, 
//						   int toYType, float toYValue);
		
//		 TranslateAnimation.RELATIVE_TO_SELF相对自身控件。数值为0-1.0 百分比
//		 TranslateAnimation.RELATIVE_TO_PARENT相对父布局。 数值为0-1.0 百分比
		TranslateAnimation translateAnimation = new TranslateAnimation(
				//X轴移动,从0移动到相对父控件高度的0.5倍
				TranslateAnimation.RELATIVE_TO_SELF, 0,
				TranslateAnimation.RELATIVE_TO_PARENT, 0.5f,
				//Y轴移动,从0移动到相对自身的高度
				TranslateAnimation.RELATIVE_TO_SELF, 0,
				TranslateAnimation.RELATIVE_TO_SELF, 1.0f);
		//通过代码设置平移动画效果
		imageView.startAnimation(AnimationProperty.setAnimProperty(translateAnimation));
		
		//通过XML设置平移动画效果
		Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
		imageView.startAnimation(AnimationProperty.setAnimProperty(loadAnimation));
	

	}

	/**
	 * 缩放动画
	 */
	public void scale(View view) {
		
		// 把图片的宽从0.5倍放大到2.0倍,高从0.5倍放大到2.0倍
//		ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 2.0f, 0.5f, 2.0f);
		ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 2.0f, 0.5f, 2.0f,
				//以相对自身控件宽的0.5被处缩放
				ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
				//以相对自身控件高的0.5被处缩放
				ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
		//通过代码设置缩放动画效果
		imageView.startAnimation(AnimationProperty.setAnimProperty(scaleAnimation));
		
		//通过XML设置缩放动画效果
		Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
		imageView.startAnimation(AnimationProperty.setAnimProperty(loadAnimation));
	}

	/**
	 * 旋转动画
	 */
	public void rotate(View view) {
		
		// 将图片从0°旋转到360°
//		RotateAnimation rotateAnimation = new RotateAnimation(0, 360);
		RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
				//相对自身控件宽的0.5倍
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				//自身控件高的0.5倍旋转
				RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		//通过代码设置旋转动画效果
		imageView.startAnimation(AnimationProperty.setAnimProperty(rotateAnimation));
		
		//通过XML设置旋转动画效果
		Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
		imageView.startAnimation(AnimationProperty.setAnimProperty(loadAnimation));
	}

	/**
	 * 透明度变化动画
	 */
	public void alpha(View view) {
		
		// 创建透明度的动画对象
		// fromAlpha 初始透明度 0：完全透明 1.0f完全不透明
		AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1.0f);
		//通过代码设置透明动画效果
		imageView.startAnimation(AnimationProperty.setAnimProperty(alphaAnimation));
		
		//通过XML设置透明动画效果
		Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
		imageView.startAnimation(AnimationProperty.setAnimProperty(loadAnimation));
	}

	/**
	 * 
	 * 组合动画合集
	 */
	public void set(View view) {
		// 创建动画集合
		AnimationSet animationSet = new AnimationSet(false);//true表示按照动画的顺序一个一个的播放动画
		animationSet.addAnimation(new TranslateAnimation(0, 10, 0, 30));
		animationSet.addAnimation( new ScaleAnimation(0.5f, 1.5f, 0.5f, 1.5f));
		animationSet.addAnimation(new RotateAnimation(0, 360,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f));
		animationSet.addAnimation(new AlphaAnimation(0, 1.0f));
		
		//代码设置播放动画集合
		imageView.startAnimation(AnimationProperty.setAnimProperty(animationSet));
		
		//通过XML设置动画集合效果
		Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.set_anim);
		imageView.startAnimation(AnimationProperty.setAnimProperty(loadAnimation));
		
	}
 
}
