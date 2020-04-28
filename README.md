<p align="center"><img src="https://github.com/Ye-Miao/StatusBarUtil/blob/master/img/logo.png"/></p>

# StatusBarUtil
Android沉浸式状态栏，支持状态栏渐变色，纯色， 全屏，亮光、暗色模式，适配android 4.4 -10.0机型，支持刘海屏，滴水屏

[![面向Android开发](https://img.shields.io/badge/%E9%9D%A2%E5%90%91-Android%E5%BC%80%E5%8F%91-%232CC159.svg)]()
[![GitHub stars](https://img.shields.io/github/stars/Ye-Miao/StatusBarUtil.svg)]()
[![GitHub forks](https://img.shields.io/github/forks/Ye-Miao/StatusBarUtil.svg)]()
[![GitHub issues](https://img.shields.io/github/issues/Ye-Miao/StatusBarUtil.svg)]()
[![GitHub license](https://img.shields.io/github/license/Ye-Miao/StatusBarUtil.svg)]()

<a href="/REAMDE_EN.md">English</a>

# Apk
<a href="http://d.7short.com/scv6">Download Apk</a>

# 机型演示
| Android-9.0 | Android-4.4 |
|:------------|:------------|
| <img src="https://github.com/Ye-Miao/StatusBarUtil/blob/master/img/Android-9.0-min.gif" width="75%"/> | <img src="https://github.com/Ye-Miao/StatusBarUtil/blob/master/img/Android-4.4-min.gif" width="75%"/> |

# Gradle引用
```
repositories {
    ...
    maven { url 'https://www.jitpack.io' }
}

dependencies {
    implementation 'com.github.Ye-Miao:StatusBarUtil:1.7.5'
}
```
# 使用方法
### 1.设置纯色状态栏
activity中使用
```
StatusBarUtil.setColor(this, mColor);
```
### 2.设置渐变色状态栏
XML布局
```
<android.support.v7.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:background="@drable/gradient_color"/>
```
activity中使用
```
StatusBarUtil.setGradientColor(this, mToolbar);
```
### 3.设置透明状态栏
activity中使用
```
StatusBarUtil.setTransparentForWindow(this);
```
#### 特别注意，如果设置的是白色透明状态栏模式，那么状态栏上方的字体颜色会被覆盖，显示不清楚，只需要再增加一句
```
StatusBarUtil.setDarkMode(this);
```

### 4.设置亮色状态栏,改变状态栏上方的字体颜色（适用于Android6.0及以上）
activity中使用
```
StatusBarUtil.setLightMode(this);
```
### 5.设置暗色状态栏,改变状态栏上方的字体颜色（适用于Android6.0及以上）
activity中使用
```
StatusBarUtil.setDarkMode(this);
```
### 6.增加View的paddingTop，增加的值是状态栏高度（具体用途可以在demo中查看）
> + 可以将Toolbar高度延伸到状态栏以实现纯色状态栏
XML布局
```
<android.support.v7.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:background="@color/blue"/>
```
activity中使用
```
StatusBarUtil.setPaddingTop(this, mToolbar);
```
> + 可以将Toolbar高度延伸到状态栏以实现渐变色状态栏
XML布局
```
<android.support.v7.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:background="@color/gradient_color"
```
activity中使用
```
StatusBarUtil.setPaddingTop(this, mToolbar);
```
# License
```
Copyright 2019 Ye-Miao

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


