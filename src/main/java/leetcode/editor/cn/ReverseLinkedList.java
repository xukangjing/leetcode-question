//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 
// 👍 1868 👎 0

package leetcode.editor.cn;

import com.shuzijun.leetcode.ListNode;

//Java：反转链表
public class ReverseLinkedList{
 public static void main(String[] args) {
  Solution solution = new ReverseLinkedList().new Solution();
     ListNode head = new ListNode(1);
     ListNode next1 = new ListNode(2);
     head.setNext(next1);
     solution.reverseList(head);
  // TO TEST
 }
 
 //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
//      //  答题思路1：先保存当前节点下一个节点，然后当前节点指向上一个节点，
//      // 更新上一个节点指针，更新当前节点指针，不断循环，然后返回上一个节点。
    /*
    理解思路二：我们可以申请两个指针，第一个指针叫 pre，最初是指向 null 的。
第二个指针 cur 指向 head，然后不断遍历 cur。
每次迭代到 cur，都将 cur 的 next 指向 pre，然后 pre 和 cur 前进一位。
都迭代完了(cur 变成 null 了)，pre 就是最后一个节点了。动画演示详见https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
    * */
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //更改指引前保存一下当前节点的后一个节点
            ListNode next = curr.next;
            //局部指针翻转 因为保存了下一个节点，所以可以吧当前节点指向上一个节点
            curr.next = prev;
            //移动上一个节点
            prev = curr;
            //移动当前节点
            curr = next;
        }
        return prev;
    }


    /**
     * 递归解法
     * @param head
     * @return
     */
    /*public ListNode reverseList(ListNode head) {
        // 法二：非递归
        // 答题思路：不断的递归拿到下一个节点，当递归到尾节点的时候，返回当前节点。
        // 修改下一个节点的下一个指针，指向自己，自己的下一个指针置空，
        // 相当于把当前节点与下一个节点的指针指向做一个反向

        // 递归退出条件，主要是head.next == null，head == null是判断测试用例的特殊值，
        // 后者才是正在的判断，因为递归退出后需要修改当前节点与下一个节点的指针指向，所以下一个节点不能为空，
        // 递归传递的是当前节点的下一个节点，所以当下一个节点没有后继节点的时候，就需要返回了
        if (head == null || head.next == null) {
            return head;
        }
        // 递归 第一次返回的是尾节点，最终返回的也是尾节点。
        ListNode newHead = reverseList(head.next);

        // 修改
        head.next.next = head;
        head.next = null;
        return newHead;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}