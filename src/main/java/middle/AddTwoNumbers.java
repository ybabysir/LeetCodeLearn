package middle;

import org.testng.annotations.Test;
import util.ListNode;

public class AddTwoNumbers {

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        addTwoNumbers(l1, l2);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(0);
        ListNode result = cur;
        int carry = 0;
        while (l1 != null || l2 != null){
            int x = l1 == null?0:l1.val;
            int y = l2 == null?0:l2.val;
            int num = x + y + carry;
            //取进位数
            carry = num / 10;
            //下一节点值
            num = num % 10;
            cur.next = new ListNode(num);

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;

            //转到下一节点
            cur = cur.next;
        }
        //若运算完成进位仍为一，则在最后节点追加一
        if(carry == 1){
            cur.next = new ListNode(1);
        }
        return result.next;
    }
}
