package com.bawei.day0222.base.base_mvp;

import java.lang.ref.WeakReference;

/**
 * ProjectName: Day0222
 * PackageName: com.bawei.day0222.base.base_mvp
 * ClassName:   BasePrenseter
 * Description: Java类的作用
 * Author: Lazy
 * CreateDate: 2020/2/22_15:36
 */
public abstract class BasePrenseter<M extends IBaseModel, V extends IBaseView> {
    protected M model;

    private WeakReference<V> weakReference;

    public BasePrenseter() {
        model = initModel();
    }

    protected abstract M initModel();

    public void attach(V v) {
        weakReference = new WeakReference<>(v);
    }

    public void detach() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    public V getView() {
        return weakReference.get();
    }

}
