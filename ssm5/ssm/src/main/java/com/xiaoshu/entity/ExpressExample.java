package com.xiaoshu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExpressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpressExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andEIdIsNull() {
            addCriterion("e_id is null");
            return (Criteria) this;
        }

        public Criteria andEIdIsNotNull() {
            addCriterion("e_id is not null");
            return (Criteria) this;
        }

        public Criteria andEIdEqualTo(Integer value) {
            addCriterion("e_id =", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotEqualTo(Integer value) {
            addCriterion("e_id <>", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdGreaterThan(Integer value) {
            addCriterion("e_id >", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("e_id >=", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLessThan(Integer value) {
            addCriterion("e_id <", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdLessThanOrEqualTo(Integer value) {
            addCriterion("e_id <=", value, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdIn(List<Integer> values) {
            addCriterion("e_id in", values, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotIn(List<Integer> values) {
            addCriterion("e_id not in", values, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdBetween(Integer value1, Integer value2) {
            addCriterion("e_id between", value1, value2, "eId");
            return (Criteria) this;
        }

        public Criteria andEIdNotBetween(Integer value1, Integer value2) {
            addCriterion("e_id not between", value1, value2, "eId");
            return (Criteria) this;
        }

        public Criteria andENameIsNull() {
            addCriterion("e_name is null");
            return (Criteria) this;
        }

        public Criteria andENameIsNotNull() {
            addCriterion("e_name is not null");
            return (Criteria) this;
        }

        public Criteria andENameEqualTo(String value) {
            addCriterion("e_name =", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotEqualTo(String value) {
            addCriterion("e_name <>", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameGreaterThan(String value) {
            addCriterion("e_name >", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameGreaterThanOrEqualTo(String value) {
            addCriterion("e_name >=", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameLessThan(String value) {
            addCriterion("e_name <", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameLessThanOrEqualTo(String value) {
            addCriterion("e_name <=", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameLike(String value) {
            addCriterion("e_name like", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotLike(String value) {
            addCriterion("e_name not like", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameIn(List<String> values) {
            addCriterion("e_name in", values, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotIn(List<String> values) {
            addCriterion("e_name not in", values, "eName");
            return (Criteria) this;
        }

        public Criteria andENameBetween(String value1, String value2) {
            addCriterion("e_name between", value1, value2, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotBetween(String value1, String value2) {
            addCriterion("e_name not between", value1, value2, "eName");
            return (Criteria) this;
        }

        public Criteria andECreatetimeIsNull() {
            addCriterion("e_createtime is null");
            return (Criteria) this;
        }

        public Criteria andECreatetimeIsNotNull() {
            addCriterion("e_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andECreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("e_createtime =", value, "eCreatetime");
            return (Criteria) this;
        }

        public Criteria andECreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("e_createtime <>", value, "eCreatetime");
            return (Criteria) this;
        }

        public Criteria andECreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("e_createtime >", value, "eCreatetime");
            return (Criteria) this;
        }

        public Criteria andECreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("e_createtime >=", value, "eCreatetime");
            return (Criteria) this;
        }

        public Criteria andECreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("e_createtime <", value, "eCreatetime");
            return (Criteria) this;
        }

        public Criteria andECreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("e_createtime <=", value, "eCreatetime");
            return (Criteria) this;
        }

        public Criteria andECreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("e_createtime in", values, "eCreatetime");
            return (Criteria) this;
        }

        public Criteria andECreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("e_createtime not in", values, "eCreatetime");
            return (Criteria) this;
        }

        public Criteria andECreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("e_createtime between", value1, value2, "eCreatetime");
            return (Criteria) this;
        }

        public Criteria andECreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("e_createtime not between", value1, value2, "eCreatetime");
            return (Criteria) this;
        }

        public Criteria andEZhiIsNull() {
            addCriterion("e_zhi is null");
            return (Criteria) this;
        }

        public Criteria andEZhiIsNotNull() {
            addCriterion("e_zhi is not null");
            return (Criteria) this;
        }

        public Criteria andEZhiEqualTo(String value) {
            addCriterion("e_zhi =", value, "eZhi");
            return (Criteria) this;
        }

        public Criteria andEZhiNotEqualTo(String value) {
            addCriterion("e_zhi <>", value, "eZhi");
            return (Criteria) this;
        }

        public Criteria andEZhiGreaterThan(String value) {
            addCriterion("e_zhi >", value, "eZhi");
            return (Criteria) this;
        }

        public Criteria andEZhiGreaterThanOrEqualTo(String value) {
            addCriterion("e_zhi >=", value, "eZhi");
            return (Criteria) this;
        }

        public Criteria andEZhiLessThan(String value) {
            addCriterion("e_zhi <", value, "eZhi");
            return (Criteria) this;
        }

        public Criteria andEZhiLessThanOrEqualTo(String value) {
            addCriterion("e_zhi <=", value, "eZhi");
            return (Criteria) this;
        }

        public Criteria andEZhiLike(String value) {
            addCriterion("e_zhi like", value, "eZhi");
            return (Criteria) this;
        }

        public Criteria andEZhiNotLike(String value) {
            addCriterion("e_zhi not like", value, "eZhi");
            return (Criteria) this;
        }

        public Criteria andEZhiIn(List<String> values) {
            addCriterion("e_zhi in", values, "eZhi");
            return (Criteria) this;
        }

        public Criteria andEZhiNotIn(List<String> values) {
            addCriterion("e_zhi not in", values, "eZhi");
            return (Criteria) this;
        }

        public Criteria andEZhiBetween(String value1, String value2) {
            addCriterion("e_zhi between", value1, value2, "eZhi");
            return (Criteria) this;
        }

        public Criteria andEZhiNotBetween(String value1, String value2) {
            addCriterion("e_zhi not between", value1, value2, "eZhi");
            return (Criteria) this;
        }

        public Criteria andKIdIsNull() {
            addCriterion("k_id is null");
            return (Criteria) this;
        }

        public Criteria andKIdIsNotNull() {
            addCriterion("k_id is not null");
            return (Criteria) this;
        }

        public Criteria andKIdEqualTo(Integer value) {
            addCriterion("k_id =", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdNotEqualTo(Integer value) {
            addCriterion("k_id <>", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdGreaterThan(Integer value) {
            addCriterion("k_id >", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("k_id >=", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdLessThan(Integer value) {
            addCriterion("k_id <", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdLessThanOrEqualTo(Integer value) {
            addCriterion("k_id <=", value, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdIn(List<Integer> values) {
            addCriterion("k_id in", values, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdNotIn(List<Integer> values) {
            addCriterion("k_id not in", values, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdBetween(Integer value1, Integer value2) {
            addCriterion("k_id between", value1, value2, "kId");
            return (Criteria) this;
        }

        public Criteria andKIdNotBetween(Integer value1, Integer value2) {
            addCriterion("k_id not between", value1, value2, "kId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}