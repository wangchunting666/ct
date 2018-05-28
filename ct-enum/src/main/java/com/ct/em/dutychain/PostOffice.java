package com.ct.em.dutychain;

/**
 * Created by Herdsric-M-003 on 2018/5/25.
 */
class PostOffice {
    enum MailHandle{
        GENERAL_DELIVERY{
            @Override
            boolean handle(Mail m) {
                switch (m.generalDelivery){
                    case YES:
                        System.out.println("use general delivery:"+m);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCAN{
            @Override
            boolean handle(Mail m) {
                switch (m.scannability){
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (m.address){
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("delivery "+m+"auto");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION{
            @Override
            boolean handle(Mail m) {
                switch (m.readability){
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (m.address){
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("delivery "+m+"normal");
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER{
            @Override
            boolean handle(Mail m) {
                switch (m.returnAddress){
                    case MISSING:
                        return false;
                    default:
                        System.out.println("Returning "+m+" to sender");
                        return true;
                }
            }
        };
        abstract boolean handle(Mail m);
    }

    static void handle(Mail mail){
        for(MailHandle handle:MailHandle.values()){
            if(handle.handle(mail)) return;
            System.out.println("dead");
        }
    }

    public static void main(String[] args) {
        for (Mail mail:Mail.generator(10)){
            System.out.println(mail.details());
            handle(mail);
            System.out.println("---------------------");
        }
    }

}
