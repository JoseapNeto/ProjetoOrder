package br.com.application.enums;

public enum OrderStatus {

    WATTING_PAYMENT(1),
    PAID(2),
    SHIPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderStatus(int code){
    this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static OrderStatus valueOf(int code){
        for(OrderStatus status : OrderStatus.values()){
            if(status.getCode() == code){
                return  status;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }

}