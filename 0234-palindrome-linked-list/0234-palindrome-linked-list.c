/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
bool isPalindrome(struct ListNode* head) {
    int count=0;
    int i=0;
    struct ListNode *temp=head;
    while(temp!=NULL)
    {
        count++;
        temp=temp->next;
    }
    temp=head;
    int *arr=(int*)malloc(count*sizeof(int));

    while(temp!=NULL)
    {
        arr[i++]=temp->val;
        temp=temp->next;
    }
    int left=0;
    int right=count-1;
    while(left<right)
    {
        if(arr[left]!=arr[right])
        {
            free(arr);
            return false;
        }
        left++;
        right--;

    }
    return true;
}