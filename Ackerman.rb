def ack(m,n)
  ans = 0
  if m == 0
    ans = n + 1
  elsif n == 0
    ans = ack(m-1,1)
  else
    ans = ack(m-1, ack(m, n-1))
  end
  return ans
end

print ack(1,1)
