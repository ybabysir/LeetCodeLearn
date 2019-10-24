package medium;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 */
import util.ListNode;

public class AddTwoNumbers {

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode cur = new ListNode(0);
//        ListNode result = cur;
//        int carry = 0;
//        while (l1 != null || l2 != null){
//            int x = l1 == null?0:l1.val;
//            int y = l2 == null?0:l2.val;
//            int num = x + y + carry;
//            //取进位数
//            carry = num / 10;
//            //下一节点值
//            num = num % 10;
//            cur.next = new ListNode(num);
//
//            if (l1 != null)
//                l1 = l1.next;
//            if (l2 != null)
//                l2 = l2.next;
//
//            //转到下一节点
//            cur = cur.next;
//        }
//        //若运算完成进位仍为一，则在最后节点追加一
//        if(carry == 1){
//            cur.next = new ListNode(1);
//        }
//        return result.next;
//    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode result = node;
        while(l1 != null || l2 != null){
            if(l1 == null){
                recursion(node, l2);
                break;
            }
            if(l2 == null){
                recursion(node, l1);
                break;
            }
            if((node.val + l1.val + l2.val) >= 10){
                node.val = (node.val + l1.val + l2.val)%10;
                node.next = new ListNode(1);
            }else {
                node.val = node.val + l1.val + l2.val;
                if(l1.next != null || l2.next != null)
                    node.next = new ListNode(0);
            }
            l1 = l1.next;
            l2 = l2.next;
            node = node.next;
        }
        return result;
    }

    void recursion(ListNode m, ListNode o){
        if((m.val + o.val) >= 10){
            m.val = (m.val + o.val)%10;
            m.next = new ListNode(1);
            if(o.next != null)
                recursion(m.next, o.next);
        }else {
            m.val = m.val + o.val;
            m.next = o.next;
        }
    }
}
