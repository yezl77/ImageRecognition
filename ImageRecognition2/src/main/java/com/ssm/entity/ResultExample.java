package com.ssm.entity;

import java.util.ArrayList;
import java.util.List;

import com.ssm.util.PaginationUtil;

public class ResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PaginationUtil pagination;

    public ResultExample() {
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

    public void setPagination(PaginationUtil pagination) {
        this.pagination=pagination;
    }

    public PaginationUtil getPagination() {
        return pagination;
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNull() {
            addCriterion("image_id is null");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNotNull() {
            addCriterion("image_id is not null");
            return (Criteria) this;
        }

        public Criteria andImageIdEqualTo(Integer value) {
            addCriterion("image_id =", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotEqualTo(Integer value) {
            addCriterion("image_id <>", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThan(Integer value) {
            addCriterion("image_id >", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("image_id >=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThan(Integer value) {
            addCriterion("image_id <", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThanOrEqualTo(Integer value) {
            addCriterion("image_id <=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdIn(List<Integer> values) {
            addCriterion("image_id in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotIn(List<Integer> values) {
            addCriterion("image_id not in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdBetween(Integer value1, Integer value2) {
            addCriterion("image_id between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("image_id not between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andMedicineIsNull() {
            addCriterion("medicine is null");
            return (Criteria) this;
        }

        public Criteria andMedicineIsNotNull() {
            addCriterion("medicine is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineEqualTo(String value) {
            addCriterion("medicine =", value, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineNotEqualTo(String value) {
            addCriterion("medicine <>", value, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineGreaterThan(String value) {
            addCriterion("medicine >", value, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineGreaterThanOrEqualTo(String value) {
            addCriterion("medicine >=", value, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineLessThan(String value) {
            addCriterion("medicine <", value, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineLessThanOrEqualTo(String value) {
            addCriterion("medicine <=", value, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineLike(String value) {
            addCriterion("medicine like", value, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineNotLike(String value) {
            addCriterion("medicine not like", value, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineIn(List<String> values) {
            addCriterion("medicine in", values, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineNotIn(List<String> values) {
            addCriterion("medicine not in", values, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineBetween(String value1, String value2) {
            addCriterion("medicine between", value1, value2, "medicine");
            return (Criteria) this;
        }

        public Criteria andMedicineNotBetween(String value1, String value2) {
            addCriterion("medicine not between", value1, value2, "medicine");
            return (Criteria) this;
        }

        public Criteria andMicIsNull() {
            addCriterion("MIC is null");
            return (Criteria) this;
        }

        public Criteria andMicIsNotNull() {
            addCriterion("MIC is not null");
            return (Criteria) this;
        }

        public Criteria andMicEqualTo(String value) {
            addCriterion("MIC =", value, "mic");
            return (Criteria) this;
        }

        public Criteria andMicNotEqualTo(String value) {
            addCriterion("MIC <>", value, "mic");
            return (Criteria) this;
        }

        public Criteria andMicGreaterThan(String value) {
            addCriterion("MIC >", value, "mic");
            return (Criteria) this;
        }

        public Criteria andMicGreaterThanOrEqualTo(String value) {
            addCriterion("MIC >=", value, "mic");
            return (Criteria) this;
        }

        public Criteria andMicLessThan(String value) {
            addCriterion("MIC <", value, "mic");
            return (Criteria) this;
        }

        public Criteria andMicLessThanOrEqualTo(String value) {
            addCriterion("MIC <=", value, "mic");
            return (Criteria) this;
        }

        public Criteria andMicLike(String value) {
            addCriterion("MIC like", value, "mic");
            return (Criteria) this;
        }

        public Criteria andMicNotLike(String value) {
            addCriterion("MIC not like", value, "mic");
            return (Criteria) this;
        }

        public Criteria andMicIn(List<String> values) {
            addCriterion("MIC in", values, "mic");
            return (Criteria) this;
        }

        public Criteria andMicNotIn(List<String> values) {
            addCriterion("MIC not in", values, "mic");
            return (Criteria) this;
        }

        public Criteria andMicBetween(String value1, String value2) {
            addCriterion("MIC between", value1, value2, "mic");
            return (Criteria) this;
        }

        public Criteria andMicNotBetween(String value1, String value2) {
            addCriterion("MIC not between", value1, value2, "mic");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
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