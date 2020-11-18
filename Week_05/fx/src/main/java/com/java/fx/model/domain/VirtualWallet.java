package com.java.fx.model.domain;

import java.math.BigDecimal;

/**
 * 钱包类（DDD）
 */
public class VirtualWallet  {
    /**
     * 钱包ID
     */
    private Long id;
    /**
     * 钱包余额 初始值为0元
     */
    private BigDecimal balance = BigDecimal.ZERO;
    /**
     * 钱包创建时间
     */
    private Long creatime = System.currentTimeMillis();
    /**
     * 是否允许透支 默认为允许
     */
    private boolean isAllowedOverdraft = true;
    /**
     * 初始透支金额 0元
     */
    private BigDecimal overdraftAmount = BigDecimal.ZERO;
    /**
     * 冻结金额(用于转账)
     */
    private BigDecimal frozenAmount = BigDecimal.ZERO;

    /**
     * 绑定钱包
     * @param preAllocatedId
     */
    public VirtualWallet(Long preAllocatedId){
        this.id = preAllocatedId;
    }

    /**
     * 冻结
     * @param amount
     */
    public void freeze(BigDecimal amount){}

    /**
     * 解冻
     * @param amount
     */
    public void unfreeze(BigDecimal amount){}

    /**
     * 增加透支金额
     * @param amount
     */
    public void increaseOverdraftAmount(BigDecimal amount){}

    /**
     * 降低透支金额
     * @param amount
     */
    public void decreaseOverdraftAmount(BigDecimal amount){}

    /**
     * 关闭透支功能
     */
    public void closeOverdraft(){}

    /**
     * 打开透支功能
     */
    public void openOverdraft(){}

    /**
     * 查询总余额
     * @return
     */
    public BigDecimal balance(){
        return this.balance;
    }

    /**
     * 获取可用余额
     * @return
     */
    public BigDecimal getAvailableBalance(){
        BigDecimal totalAvailableBalance = this.balance.subtract(frozenAmount);
        if (isAllowedOverdraft){
            totalAvailableBalance.add(this.overdraftAmount);
        }
        return totalAvailableBalance;
    }

    /**
     * 转出
     * @param amount
     */
    public void debit(BigDecimal amount) throws Exception {
        BigDecimal totalAvailableBalance = getAvailableBalance();
        if (totalAvailableBalance.compareTo(amount) < 0){
            throw new Exception("余额不足!");
        }
        this.balance.subtract(amount);
    }

    /**
     * 转入
     * @param amount
     */
    public void credit(BigDecimal amount) throws Exception {
        if (amount.compareTo(BigDecimal.ZERO) < 0){
            throw new Exception("非法金额!");
        }
        this.balance.add(amount);
    }

    @Override
    public String toString() {
        return "VirtualWallet{" +
                "id=" + id +
                ", balance=" + balance +
                ", creatime=" + creatime +
                ", isAllowedOverdraft=" + isAllowedOverdraft +
                ", overdraftAmount=" + overdraftAmount +
                ", frozenAmount=" + frozenAmount +
                '}';
    }
}
