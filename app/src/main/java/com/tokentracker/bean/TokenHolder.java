//package com.tokentracker.bean;
//
//import org.greenrobot.greendao.annotation.Entity;
//import org.greenrobot.greendao.annotation.Id;
//import org.greenrobot.greendao.annotation.ToOne;
//import org.greenrobot.greendao.annotation.Generated;
//import org.greenrobot.greendao.DaoException;
//
///**
// * Created by Riven on 2018/5/9.
// */
//@Entity
//public class TokenHolder {
//        @Id(autoincrement = true)
//        private Long id;
//        private String tokenAddress;
//
//        private Long tokenInfoId;
//        @ToOne(joinProperty = "tokenInfoId")
//        private TokenInfo tokenInfo;
//        /** Used to resolve relations */
//        @Generated(hash = 2040040024)
//        private transient DaoSession daoSession;
//        /** Used for active entity operations. */
//        @Generated(hash = 554198)
//        private transient TokenHolderDao myDao;
//        @Generated(hash = 263124415)
//        public TokenHolder(Long id, String tokenAddress, Long tokenInfoId) {
//            this.id = id;
//            this.tokenAddress = tokenAddress;
//            this.tokenInfoId = tokenInfoId;
//        }
//        @Generated(hash = 197405721)
//        public TokenHolder() {
//        }
//        public Long getId() {
//            return this.id;
//        }
//        public void setId(Long id) {
//            this.id = id;
//        }
//        public String getTokenAddress() {
//            return this.tokenAddress;
//        }
//        public void setTokenAddress(String tokenAddress) {
//            this.tokenAddress = tokenAddress;
//        }
//        public Long getTokenInfoId() {
//            return this.tokenInfoId;
//        }
//        public void setTokenInfoId(Long tokenInfoId) {
//            this.tokenInfoId = tokenInfoId;
//        }
//        @Generated(hash = 67909383)
//        private transient Long tokenInfo__resolvedKey;
//        /** To-one relationship, resolved on first access. */
//        @Generated(hash = 683018540)
//        public TokenInfo getTokenInfo() {
//            Long __key = this.tokenInfoId;
//            if (tokenInfo__resolvedKey == null
//                    || !tokenInfo__resolvedKey.equals(__key)) {
//                final DaoSession daoSession = this.daoSession;
//                if (daoSession == null) {
//                    throw new DaoException("Entity is detached from DAO context");
//                }
//                TokenInfoDao targetDao = daoSession.getTokenInfoDao();
//                TokenInfo tokenInfoNew = targetDao.load(__key);
//                synchronized (this) {
//                    tokenInfo = tokenInfoNew;
//                    tokenInfo__resolvedKey = __key;
//                }
//            }
//            return tokenInfo;
//        }
//        /** called by internal mechanisms, do not call yourself. */
//        @Generated(hash = 336391963)
//        public void setTokenInfo(TokenInfo tokenInfo) {
//            synchronized (this) {
//                this.tokenInfo = tokenInfo;
//                tokenInfoId = tokenInfo == null ? null : tokenInfo.getId();
//                tokenInfo__resolvedKey = tokenInfoId;
//            }
//        }
//        /**
//         * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
//         * Entity must attached to an entity context.
//         */
//        @Generated(hash = 128553479)
//        public void delete() {
//            if (myDao == null) {
//                throw new DaoException("Entity is detached from DAO context");
//            }
//            myDao.delete(this);
//        }
//        /**
//         * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
//         * Entity must attached to an entity context.
//         */
//        @Generated(hash = 1942392019)
//        public void refresh() {
//            if (myDao == null) {
//                throw new DaoException("Entity is detached from DAO context");
//            }
//            myDao.refresh(this);
//        }
//        /**
//         * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
//         * Entity must attached to an entity context.
//         */
//        @Generated(hash = 713229351)
//        public void update() {
//            if (myDao == null) {
//                throw new DaoException("Entity is detached from DAO context");
//            }
//            myDao.update(this);
//        }
//        /** called by internal mechanisms, do not call yourself. */
//        @Generated(hash = 2131628192)
//        public void __setDaoSession(DaoSession daoSession) {
//            this.daoSession = daoSession;
//            myDao = daoSession != null ? daoSession.getTokenHolderDao() : null;
//        }
//}
