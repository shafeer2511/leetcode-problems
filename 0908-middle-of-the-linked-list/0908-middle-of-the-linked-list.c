/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* middleNode(struct ListNode* head) {
    int count=0;
    if(head->next==NULL)
    {
        return head;
    }
    struct ListNode* temp =head;
    while(temp->next!=NULL)
    {
        temp=temp->next;
        count++;
    }
    int mid=(count+1)/2;
    while(mid>0)
    {
        head=head->next;
        mid--;
    }
    return head;
}