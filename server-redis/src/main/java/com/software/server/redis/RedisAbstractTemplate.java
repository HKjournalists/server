package com.software.server.redis;


public abstract class RedisAbstractTemplate {

    protected AtomRedisPool atomRedisPool; //控制资源的上下文对象

    public AtomRedisPool getAtomRedisPool() {
        return atomRedisPool;
    }

    public void setAtomRedisPool(AtomRedisPool atomRedisPool) {
        this.atomRedisPool = atomRedisPool;
    }
}
